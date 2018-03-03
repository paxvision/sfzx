package com.geek.dao;

import com.geek.entity.SourceFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuanyang
 */
@Repository
public interface SourceFileDao {

    /**
     * 添加一张图片
     * @param sourceFile
     * @return
     */
    int insertSourceFile(SourceFile sourceFile);

    /**
     * 删除一张图片
     * @param imageId
     * @return
     */
    int deleteSourceFile(Integer imageId);

    /**
     * 批量删除图片
     * @param imageIds
     * @return
     */
    int deleteSourceFiles(@Param("imageIds") List<Integer> imageIds);

    /**
     * 修改一张图片
     * @param sourceFile
     * @return
     */
    int updateSourceFile(SourceFile sourceFile);

    /**
     * 查找所有的图片
     * @return
     */
    List<SourceFile> selectAllSourceFiles();

    /**
     * 获取某张图片的地址
     * @param fileId
     * @return
     */
    String findSourceFilePath(Integer fileId);

    /**
     * 获取一组图片的地址
     * @param fileIds
     * @return
     */
    List<String> findSourceFilePaths(@Param("fileIds") List<Integer> fileIds);

}
