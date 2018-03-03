package com.geek.service;

import com.geek.dao.FirstNavigationDao;
import com.geek.entity.FirstNavigation;
import com.geek.entity.SecondNavigation;
import com.geek.exception.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author hetiantian
 */
@Service
public class FirstNavigationService {

    //一级导航栏持久化接口
    @Autowired
    private FirstNavigationDao firstNavigationDao;

    /**
     * 按照升序查找所有的一级导航栏
     * @return
     */
    public List<FirstNavigation> selectAllFirstNavigationName() {
        List<FirstNavigation> firstNavigationList = firstNavigationDao.selectAllFirstNavigationName();

        if (firstNavigationList == null || firstNavigationList.size() == 0){
            throw new ErrorException("没有任何内容");
        }
        return firstNavigationList;
    }

    /**
     * 根据一级导航栏升序查询出所有的二级导航
     * @return
     * */
    public List<SecondNavigation> selectAllSecondNavigationById() {
        List<SecondNavigation>secondNavigationList = firstNavigationDao.selectAllSecondNavigationById();
        if(secondNavigationList == null || secondNavigationList.size() == 0) {
            throw new ErrorException("没有任何内容");
        }
        return secondNavigationList;
    }

    /**
     * 删除一级导航栏
     * @param firstNavigationId
     * @return
     * */
    public void deleteFirstNavigation(Integer firstNavigationId) {

    }

    /**
     * 批量删除一级导航栏
     * @param firstNavigationList
     * @return
     * */
    public void batchDeleteFirstNavigation(List<FirstNavigation>firstNavigationList) {

    }

    /**
     * 增加一级导航栏
     * @param firstNavigation
     * */
    public void insertFirstNavigation(FirstNavigation firstNavigation) {

    }

    /**
     * 修改一级导航栏
     * @param firstNavigation
     * */
    public void updateFirstNavigation(FirstNavigation firstNavigation) {

    }

    /**
     * 增加查看次数，每次调用都加1
     * @param firstNavigationId
     * @return
     * */
    public int addfirstNavigationView(Integer firstNavigationId) {
        return firstNavigationDao.addfirstNavigationView(firstNavigationId);
    }

    /**
     * 根据二级导航栏查询出所有的有关一二级导航栏的相关信息
     * @param
     * @return
     * */
    public FirstNavigation selectFirstNavigationAndSecondNavigation(String secondNavigationName) {
        FirstNavigation firstNavigation1 = firstNavigationDao.selectFirstNavigationAndSecondNavigation(secondNavigationName);
        if(firstNavigation1 == null) {
            throw new ErrorException("没有查询到任何信息");
        }
        return firstNavigation1;
    }
}
