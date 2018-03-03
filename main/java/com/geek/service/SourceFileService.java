package com.geek.service;

import com.geek.dao.SourceFileDao;
import com.geek.entity.SourceFile;
import com.geek.exception.ErrorException;
import com.geek.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @author yuanyang
 */
@Service
public class SourceFileService {

    //图片持久层接口
    @Autowired
    private SourceFileDao sourceFileDao;

    //文件存储工具类
    @Autowired
    private FileUtil fileUtil;

    /**
     * 插入一张图片
     * @param multipartFile
     */
    public void insertFile(MultipartFile multipartFile){
        if (multipartFile == null){
            throw new ErrorException("请选择图片");
        }
        //存储图片
        fileUtil.saveFile(multipartFile,SourceFile.class.getSimpleName(),null);
        SourceFile sourceFile = new SourceFile();
        //图片名
        sourceFile.setFileName(multipartFile.getOriginalFilename());
        //大小
        sourceFile.setFileSize((int) multipartFile.getSize());
        //存放时间
        sourceFile.setFileTime(new Date());
        //虚拟路径
        sourceFile.setFilePath(fileUtil.getVirtualPath());
        //类型
        sourceFile.setFileType(sourceFile.getFileName().substring(sourceFile.getFileName().charAt('.')));
        if (sourceFileDao.insertSourceFile(sourceFile) != 1){
            //存储失败则删除图片
            fileUtil.deleteFile(sourceFile.getFilePath());
            throw new ErrorException("存储失败,请重试");
        }
    }

    /**
     * 删除一张图片
     * @param fileId
     */
    public void deleteFile(Integer fileId){
        String filePath = sourceFileDao.findSourceFilePath(fileId);
        if (sourceFileDao.deleteSourceFile(fileId) != 1){
            throw new ErrorException("删除失败,请重试");
        }
        fileUtil.deleteFile(filePath);
    }

    /**
     * 批量删除图片
     * @param fileIds
     */
    public void deleteFiles(List<Integer> fileIds){
        List<String> imageAddresses = sourceFileDao.findSourceFilePaths(fileIds);
        if (sourceFileDao.deleteSourceFiles(fileIds) != fileIds.size()){
            throw new ErrorException("删除失败,请重试");
        }
        fileUtil.deleteFiles(imageAddresses);
    }

    /**
     * 修改一张图片
     * @param sourceFile
     * @param multipartFile
     */
    public void updateImage(SourceFile sourceFile, MultipartFile multipartFile){
        if (multipartFile != null){
            String oldPath = sourceFileDao.findSourceFilePath(sourceFile.getFileId());
            fileUtil.saveFile(multipartFile,SourceFile.class.getSimpleName(),null);
            //图片名
            sourceFile.setFileName(multipartFile.getOriginalFilename());
            //大小
            sourceFile.setFileSize((int) multipartFile.getSize());
            //存放时间
            sourceFile.setFileTime(new Date());
            //虚拟路径
            sourceFile.setFilePath(fileUtil.getVirtualPath());
            //类型
            sourceFile.setFileType(sourceFile.getFileName().substring(sourceFile.getFileName().charAt('.')));
            if (sourceFileDao.updateSourceFile(sourceFile) != 1){
                fileUtil.deleteFile(sourceFile.getFilePath());
                throw new ErrorException("更新失败,请重试");
            }
            fileUtil.deleteFile(oldPath);
        }
        if (sourceFileDao.updateSourceFile(sourceFile) != 1){
            throw new ErrorException("更新失败,请重试");
        }
    }

    /**
     * 获取所有图片
     * @return
     */
    public List<SourceFile> selectAllFiles(){
        List<SourceFile> sourceFiles = sourceFileDao.selectAllSourceFiles();
        if (sourceFiles == null || sourceFiles.size() == 0)
            throw new ErrorException("没有任何图片");
        return sourceFiles;
    }
}
