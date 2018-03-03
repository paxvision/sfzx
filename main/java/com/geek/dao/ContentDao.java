package com.geek.dao;

import com.geek.entity.Content;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuanyang
 */
@Repository
public interface ContentDao {

    /**
     * 添加一篇内容
     * @param content
     * @return
     */
    int insertContent(Content content);

    /**
     * 删除一篇内容
     * @param contentId
     * @return
     */
    int deleteContent(Integer contentId);

    /**
     * 批量删除
     * @param contentIds
     * @return
     */
    int deleteContents(@Param("contentIds") List<Integer> contentIds);

    /**
     * 修改一篇内容
     * @param content
     * @return
     */
    int updateContent(Content content);

    /**
     * 增加阅读量
     * @param contentId
     * @return
     */
    int addView(Integer contentId);

    /**
     * 查找所有的内容
     * @return
     */
    List<Content> selectAllContents();

    /**
     * 通过栏目查找对应的内容
     * @param contentPart
     * @return
     */
    List<Content> selectContentByPart(Integer contentPart);

}
