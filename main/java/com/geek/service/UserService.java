package com.geek.service;

import com.geek.dao.UserDao;
import com.geek.entity.User;
import com.geek.exception.ErrorException;
import com.geek.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    private void validate(User user){

    }

    private LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    public void login(String loginName,String password, HttpServletRequest request){
        String rightPass = userDao.findPassword(loginName);
        if (rightPass == null || "".equals(rightPass)){
            throw new ErrorException("用户名或密码错误");
        }

        try {
            if (rightPass.equals(EncryptUtil.MD5(password))) {
                User user = userDao.findUserByLoginName(loginName);
                request.getSession().setAttribute("user",user);
                user.setRecentTime(getLocalDateTime());
                user.setRecentIp(request.getRemoteAddr());
                userDao.updateUser(user);
                return;
            }
            throw new ErrorException("用户名或密码错误");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user){
        validate(user);
        isExist(user.getUserName());
        try {
            user.setPassword(EncryptUtil.MD5(user.getPassword()));
            user.setCreateTime(getLocalDateTime());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (userDao.insertUser(user) != 1){
            throw new ErrorException("添加管理员失败");
        }
    }

    private void isExist(String loginName) {
        if (userDao.isExist(loginName) >= 1){
            throw new ErrorException("用户名已存在");
        }
    }

    public void deleteUser(Integer id){
        if (userDao.deleteUser(id) != 1){
            throw new ErrorException("删除管理员失败");
        }
    }

    public void deleteUsers(String ids){
        if (ids == null){
            throw new ErrorException("没有选择删除的对象");
        }
        String[] strings = ids.split(",");
        Integer[] id = new Integer[strings.length];
        for (int i = 0; i < strings.length; i ++){
            id[i] = Integer.valueOf(strings[i]);
        }
        if (userDao.deleteUsers(id) != id.length){
            throw new ErrorException("删除管理员失败");
        }
    }

    public void updateUser(User user){
        validate(user);
        if (user.getPassword() != null || !"".equals(user.getPassword())){
            try {
                user.setPassword(EncryptUtil.MD5(user.getPassword()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (userDao.updateUser(user) != 1){
            throw new ErrorException("更新管理员失败");
        }
    }

    public List<User> findAllUsers(){
        List<User> users = userDao.findAllUser();
        if (users == null) {
            throw new ErrorException("获取管理员失败");
        } else if (users.size() == 0){
            throw new ErrorException("没有管理员");
        }
        return users;
    }


}
