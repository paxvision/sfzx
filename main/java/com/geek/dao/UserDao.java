package com.geek.dao;

import com.geek.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int insertUser(User user);

    int deleteUser(Integer id);

    int updateUser(User user);

    List<User> findAllUser();

    User findUserByLoginName(String loginName);

    String findPassword(String userName);

    int deleteUsers(Integer[] ids);

    int isExist(String loginName);
}
