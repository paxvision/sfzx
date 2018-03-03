package com.geek.dao;

import com.geek.entity.SecondNavigation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author hetiantian
 */
@Repository
public interface SecondNavigationDao {

    /**
     * 批量删除二级导航栏
     * @param secondNavigationIds
     * @return int
     **/
    int batchDeleteSecondNavigation(@Param("secondNavigationIds") List<Integer> secondNavigationIds);

    /**
     * 根据id删除二级导航栏
     *
     * @param secondNavigationId
     **/
    int deleteSecondNavigation(Integer secondNavigationId);

    /**
     * 增加一级导航栏id对应删除二级导航栏
     * @param firstNavigationId,secondNavigation
     * @return
     */
    int insertSecondNavigation(Integer firstNavigationId, SecondNavigation secondNavigation);

    /**
     * 修改二级导航栏
     * @param
     * @return
     * */
    int updateSecondNavigation(SecondNavigation secondNavigation);

    /**
     *根据导航栏名字查询相应导航栏的信息
     * @param secondNavigationName
     * @return List
     */
    List<SecondNavigation> selectSecondNavigationByName(String secondNavigationName);

    /**
     * 查询出所有的二级导航栏
     * @return List
     * */
    List<SecondNavigation> selectAllSecondNavigation();

    /**
     * 删除所有的二级导航栏
     * @return
     * */
    int deleteAllSecondNavigation();

    /**
     * 查询出二级导航栏的数量
     * @return
     * */
    int selectTotalSecondNavigation();

    /**
     *存储二级文章内容
     * @return
     */
    int insertArticleContent(SecondNavigation secondNavigation);

    /**
     * 根据一级导航栏查询出所有的二级导航栏
     * @param firstNavigationName
     * @return
     * */
    List<SecondNavigation> selectSecondNavigations(String firstNavigationName);

    /**
     * 根据二级导航栏的名字查询出二级导航栏的有关信息
     * @param secondNavigationName
     * @return
     * */
     SecondNavigation selectSecondNavigation(String secondNavigationName);

    /**
     * 存储图片的url
     * @param pictureUrl
     */
     void insertSecondNavigationPicture(String pictureUrl);
}