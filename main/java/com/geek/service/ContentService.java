package com.geek.service;

import com.geek.dao.ContentDao;
import com.geek.entity.Content;
import com.geek.exception.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yuanyang
 */
@Service
public class ContentService {

    //内容持久层接口
    @Autowired
    private ContentDao contentDao;

    /**
     * 添加一项内容
     * @param content
     */
    public void insertContent(Content content){
        content.setContentTime(new Date());
        if (contentDao.insertContent(content) != 1){
            throw new ErrorException("添加失败,请重试");
        }
    }

    /**
     * 删除一项内容
     * @param contentId
     */
    public void deleteContent(Integer contentId){
        if (contentDao.deleteContent(contentId) != 1){
            throw new ErrorException("删除失败,请重试");
        }
    }

    /**
     * 批量删除内容
     * @param contentIds
     */
    public void deleteContents(List<Integer> contentIds){
        if (contentDao.deleteContents(contentIds) != contentIds.size()){
            throw new ErrorException("删除失败,请重试");
        }
    }

    /**
     * 修改一项内容
     * @param content
     */
    public void updateContent(Content content){
        if (contentDao.updateContent(content) != 1){
            throw new ErrorException("更新失败,请重试");
        }
    }

    /**
     * 获取所有的内容
     * @return
     */
    public List<Content> selectAllContents(){
        List<Content> contents = contentDao.selectAllContents();
        if (contents == null || contents.size() == 0){
            throw new ErrorException("没有任何内容");
        }
        return contents;
    }

    /**
     * 通过对应栏目查找内容
     * @param contentPart
     * @return
     */
    public List<Content> selectContentByPart(Integer contentPart){
        List<Content> contents = contentDao.selectContentByPart(contentPart);
        if (contents == null || contents.size() == 0){
            throw new ErrorException("没有任何内容");
        }
        return contents;
    }

}