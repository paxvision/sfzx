package com.geek.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author hetiantian
 */
public class FirstNavigation {

    //导航栏编号,自增
    private Integer firstNavigationId;
    //导航栏序列
    private Integer firstNavigationSequence;
    //查看次数
    private Integer firstNavigationView;
    //导航栏名字
    private String firstNavigationBarName;
    //发布时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstNavigationCreateDate;
    //一级导航栏下面的二级导航栏
    private List<SecondNavigation>secondNavigationList;

    public FirstNavigation() {
    }

    public FirstNavigation(Integer firstNavigationId, Integer firstNavigationSequence, Integer firstNavigationView, String firstNavigationBarName,
                           Date firstNavigationCreateDate, List<SecondNavigation> secondNavigationList) {
        this.firstNavigationId = firstNavigationId;
        this.firstNavigationSequence = firstNavigationSequence;
        this.firstNavigationView = firstNavigationView;
        this.firstNavigationBarName = firstNavigationBarName;
        this.firstNavigationCreateDate = firstNavigationCreateDate;
        this.secondNavigationList = secondNavigationList;
    }

    public Integer getFirstNavigationId() {
        return firstNavigationId;
    }

    public void setFirstNavigationId(Integer firstNavigationId) {
        this.firstNavigationId = firstNavigationId;
    }

    public Integer getFirstNavigationSequence() {
        return firstNavigationSequence;
    }

    public void setFirstNavigationSequence(Integer firstNavigationSequence) {
        this.firstNavigationSequence = firstNavigationSequence;
    }

    public Integer getFirstNavigationView() {
        return firstNavigationView;
    }

    public void setFirstNavigationView(Integer firstNavigationView) {
        this.firstNavigationView = firstNavigationView;
    }

    public String getFirstNavigationBarName() {
        return firstNavigationBarName;
    }

    public void setFirstNavigationBarName(String firstNavigationBarName) {
        this.firstNavigationBarName = firstNavigationBarName;
    }

    public Date getFirstNavigationCreateDate() {
        return firstNavigationCreateDate;
    }

    public void setFirstNavigationCreateDate(Date firstNavigationCreateDate) {
        this.firstNavigationCreateDate = firstNavigationCreateDate;
    }

    public List<SecondNavigation> getSecondNavigationList() {
        return secondNavigationList;
    }

    public void setSecondNavigationList(List<SecondNavigation> secondNavigationList) {
        this.secondNavigationList = secondNavigationList;
    }

    @Override
    public String toString() {
        return "FirstNavigation{" +
                "firstNavigationId=" + firstNavigationId +
                ", firstNavigationSequence=" + firstNavigationSequence +
                ", firstNavigationView=" + firstNavigationView +
                ", firstNavigationBarName='" + firstNavigationBarName + '\'' +
                ", firstNavigationCreateDate=" + firstNavigationCreateDate +
                ", secondNavigationList=" + secondNavigationList +
                '}';
    }
}
