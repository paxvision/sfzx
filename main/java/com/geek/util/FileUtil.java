package com.geek.util;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * 文件处理工具类
 * @author yuanyang
 * @version 1.0
 */
@Service
public class FileUtil {

    private final String realDir = "E:"+File.separator+"picture" + File.separator + "blog";
    //private final String realDir = "/srv/www/blog";
    private final String virtualDir = File.separator + "file"; //虚拟磁盘目录
    private String extension;   //文件后缀

    private String fileName;    //文件名
    private String className;   //类名
    private long timeStamp;     //时间戳

    private String realPath;    //真实路径
    private String virtualPath; //虚拟路径

    /**
     * 将文件存入磁盘中
     * @param file      文件
     * @param clazzName 全类名
     * @param id        主码
     * @return
     */
    public boolean saveFile(MultipartFile file, String clazzName, String id) {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        if (file.getSize() > 209715200) {
//            throw new OverSizeException("文件过大,只能上传小于200M的文件!");
        } else {
            timeStamp = System.currentTimeMillis();
            className = clazzName;
            fileName = file.getOriginalFilename();
            extension = fileName.substring(fileName.lastIndexOf(".") + 1);

            createFilePath(id);

            File file1 = new File(getRealPath());   //创建文件
            try {
                fileOutputStream = new FileOutputStream(file1);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

                bufferedOutputStream.write(file.getBytes());
                if (file1.exists()) {
                    return true;
                } else
                    return false;
            } catch (FileNotFoundException e) {
                e.getMessage();
            } catch (IOException e) {
                e.getMessage();
            } finally {
                if (bufferedOutputStream != null){
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
                if (fileOutputStream != null){
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
            }
        }
        return false;
    }
    /**
     * 更新文件
     * @param file
     * @param oldFilePath
     * @param clazzName
     * @param id
     * @return
     */
    public boolean updateFile(MultipartFile file, String oldFilePath, String clazzName, String id){
        //先删除原文件
        deleteFile(oldFilePath);
        //存新文件
        boolean flag = saveFile(file,clazzName,id);
        return flag;
    }

    /**
     * 删除文件
     * @param filePath
     */
    public void deleteFile(String filePath){
        if (ValidateUtil.notEmpty(filePath)){
            File file = new File(filePath.replace(virtualDir,realDir));
            if (file.exists()) {
                try {
                    FileUtils.forceDelete(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 批量删除文件
     * @param filePaths
     */
    public void deleteFiles(List<String> filePaths){
        if (filePaths != null || filePaths.size() != 0)
            for (String filePath:filePaths){
                deleteFile(filePath);
            }
    }

    /**
     * 创建文件路径
     * @param id
     */
    public void createFilePath(String id) {
        realPath = realDir + File.separator + className + "_" + timeStamp + "_" + id + "." + extension.toLowerCase();
        virtualPath = virtualDir + File.separator + className + "_" + timeStamp + "_" + id + "." + extension.toLowerCase();
    }

    /**
     * 返回文件的虚拟路径
     * @return
     */
    public String getVirtualPath() {
        return virtualPath;
    }

    /**
     * 返回文件的真实路径
     * @return
     */
    public String getRealPath() {
        return realPath;
    }
}
