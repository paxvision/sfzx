package com.geek.service;

import com.geek.dao.SecondNavigationDao;
import com.geek.entity.SecondNavigation;
import com.geek.exception.ErrorException;
import com.geek.util.FileUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author hetiantian
 */
@Service
public class SecondNavigationService {

    //二级导航栏持久化接口
    @Autowired
    private SecondNavigationDao secondNavigationDao;

    //文件存储工具
    private FileUtil fileUtil;

    /**
     * 批量删除二级导航栏
     * @param secondNavigationIds
     * @return
     **/
    public void batchDeleteSecondNavigation(List<Integer> secondNavigationIds) {
        if(secondNavigationDao.batchDeleteSecondNavigation(secondNavigationIds) != secondNavigationIds.size()) {
            throw new ErrorException("批量删除失败");
        }
    }

    /**
     * 根据id删除二级导航栏
     * @param secondNavigationId
     * @return
     **/
    public void deleteSecondNavigation(Integer secondNavigationId) {

    }

    /**
     * 增加一级导航栏id对应删除二级导航栏
     * @param
     * @return
     */
    public void insertSecondNavigation(Integer firstNavigationId) {

    }

    /**
     * 修改二级导航栏
     * @param
     * */
    public void updateSecondNavigation(SecondNavigation secondNavigation) {

    }

    /**
     *根据导航栏名字查询相应导航栏的信息
     * @param secondNavigationName
     * @return SecondNavigation
     */
    public List<SecondNavigation> selectSecondNavigationByName(String secondNavigationName) {
        List<SecondNavigation> secondNavigationList = secondNavigationDao.selectSecondNavigationByName(secondNavigationName);
        if(secondNavigationList == null || secondNavigationList.size() ==0) {
            throw new ErrorException("没有任何内容");
        }
        return secondNavigationList;
    }

    /**
     * 查询出所有的二级导航栏
     * @param pageNo 查询条件，可为空，默认为1
     * @param pageSize 查询条件，可为空，默认为1
     * @return List
     * */
    public List<SecondNavigation> selectAllSecondNavigation(Integer pageNo,Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 1 : pageSize;
        System.out.println("pageNo: " + pageNo);
        System.out.println("pageSize: " + pageSize);
        PageHelper.startPage(pageNo,pageSize);//告诉拦截器我要开始分页了
        List<SecondNavigation> secondNavigations = secondNavigationDao.selectAllSecondNavigation();
        if(secondNavigations.size() ==0 || secondNavigations == null) {
            throw new ErrorException("没有任何内容");
        }
        return secondNavigations;
    }

    /**
     * 删除所有的二级导航栏
     * */
    public void deleteAllSecondNavigation() {

    }

    /**
     * 查询出二级导航栏的数量
     * @return
     * */
    public int selectTotalSecondNavigation() {
        return secondNavigationDao.selectTotalSecondNavigation();
    }

    /**
     * 插入文章
     * @param secondNavigation 文章内容
     * */
    public void insertArticleContent(SecondNavigation secondNavigation) {
        if(secondNavigation == null) {
            throw new ErrorException("请输入文章内容");
        }
        //存储文章内容
        secondNavigation.setArticleCreateDate(new Date());
        secondNavigationDao.insertArticleContent(secondNavigation);
    }

    /**
     * 根据一级导航栏查询出所有的二级导航栏
     * @param firstNavigationName
     * @return List
     * */
    public List<SecondNavigation> selectSecondNavigations(String firstNavigationName) {
        List<SecondNavigation> secondNavigationList = secondNavigationDao.selectSecondNavigations(firstNavigationName);
        if(secondNavigationList == null || secondNavigationList.size() == 0) {
            throw new ErrorException("没有查询到相应的二级导航栏");
        }
        return secondNavigationList;
    }

    /**
     * 根据二级导航栏的名字查询出二级导航栏的有关信息
     * @param secondNavigationName
     * @return
     * */
    public SecondNavigation selectSecondNavigation(String secondNavigationName) {
        if(secondNavigationName == null || secondNavigationName == "") {
            throw new ErrorException("没有获取到二级导航栏的名字");
        }
        return secondNavigationDao.selectSecondNavigation(secondNavigationName);
    }

    /**
     * 为文本编辑器添加图片
     * @param picture
     * @return
     * */

    public String insertSecondNavigationPicture(MultipartFile picture) throws IOException {
        String fileName = picture.getOriginalFilename();  //获取图片名称
        File imageFile= new File("D:" + File.separator, fileName);
        String pictureUrl = "D:" + File.separator + fileName;
        picture.transferTo(imageFile);
        secondNavigationDao.insertSecondNavigationPicture(pictureUrl);
        return pictureUrl;
    }
}
