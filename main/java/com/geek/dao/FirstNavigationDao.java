package com.geek.dao;


import com.geek.entity.FirstNavigation;
import com.geek.entity.SecondNavigation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hetiantian
 */
@Repository
public interface FirstNavigationDao {

    /**
     * 按照升序查找所有的一级导航栏
     * @return
     */
    List<FirstNavigation> selectAllFirstNavigationName();

    /**
     * 根据一级导航栏升序查询出所有的二级导航
     * @return
     * */
    List<SecondNavigation> selectAllSecondNavigationById();

    /**
     * 根据id删除一级导航栏
     * @param firstNavigationId
     * @return
     * */
    int deleteFirstNavigation(Integer firstNavigationId);

    /**
     * 批量删除一级导航栏
     * @param firstNavigationList
     * @return
     * */
    int batchDeleteFirstNavigation(List<FirstNavigation>firstNavigationList);

    /**
     * 增加一级导航栏
     * @param firstNavigation
     * */
     int insertFirstNavigation(FirstNavigation firstNavigation);

     /**
      * 修改一级导航栏
      * @param firstNavigation
      * */
      int updateFirstNavigation(FirstNavigation firstNavigation);

     /**
      * 增加查看次数，每次调用都加1
      * @param firstNavigationId
      * @return
      * */
     int addfirstNavigationView(Integer firstNavigationId);

     /**
      * 根据二级导航栏查询出所有的有关一二级导航栏的相关信息
      * @param secondNavigationName
      * @return
      * */
     FirstNavigation selectFirstNavigationAndSecondNavigation(String secondNavigationName);
}
