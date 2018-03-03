package com.geek.entity;

import java.time.LocalDateTime;

public class User {

    private Integer id;
    private String loginName;
    private String password;
    private String userName;
    private LocalDateTime recentTime;
    private String recentIp;
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getRecentTime() {
        return recentTime;
    }

    public void setRecentTime(LocalDateTime recentTime) {
        this.recentTime = recentTime;
    }

    public String getRecentIp() {
        return recentIp;
    }

    public void setRecentIp(String recentIp) {
        this.recentIp = recentIp;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
