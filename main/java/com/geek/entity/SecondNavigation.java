package com.geek.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hetiantian
 */
public class SecondNavigation {

    //导航栏编号,自增
    private Integer secondNavigationId;
    //导航栏序列
    private Integer secondNavigationSequence;
    //查看次数
    private Integer secondNavigationView;
    //导航栏名字
    private String secondNavigationBarName;
    //发布时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date secondNavigationCreateDate;
    //二级导航栏下面的文章
    private String articleTitle;
    //二级导航栏下文章的存储地址
    private String articleContent;
    //二级导航栏下文章的更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date articleCreateDate;

    private String pictureUrl;

    public SecondNavigation() {
    }

    public SecondNavigation(Integer secondNavigationId, Integer secondNavigationSequence, Integer secondNavigationView,
                            String secondNavigationBarName, Date secondNavigationCreateDate, String articleTitle,
                            String articleContent, Date articleCreateDate, String pictureUrl) {
        this.secondNavigationId = secondNavigationId;
        this.secondNavigationSequence = secondNavigationSequence;
        this.secondNavigationView = secondNavigationView;
        this.secondNavigationBarName = secondNavigationBarName;
        this.secondNavigationCreateDate = secondNavigationCreateDate;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleCreateDate = articleCreateDate;
        this.pictureUrl = pictureUrl;
    }

    public Integer getSecondNavigationId() {
        return secondNavigationId;
    }

    public void setSecondNavigationId(Integer secondNavigationId) {
        this.secondNavigationId = secondNavigationId;
    }

    public Integer getSecondNavigationSequence() {
        return secondNavigationSequence;
    }

    public void setSecondNavigationSequence(Integer secondNavigationSequence) {
        this.secondNavigationSequence = secondNavigationSequence;
    }

    public Integer getSecondNavigationView() {
        return secondNavigationView;
    }

    public void setSecondNavigationView(Integer secondNavigationView) {
        this.secondNavigationView = secondNavigationView;
    }

    public String getSecondNavigationBarName() {
        return secondNavigationBarName;
    }

    public void setSecondNavigationBarName(String secondNavigationBarName) {
        this.secondNavigationBarName = secondNavigationBarName;
    }

    public Date getSecondNavigationCreateDate() {
        return secondNavigationCreateDate;
    }

    public void setSecondNavigationCreateDate(Date secondNavigationCreateDate) {
        this.secondNavigationCreateDate = secondNavigationCreateDate;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(Date articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "SecondNavigation{" +
                "secondNavigationId=" + secondNavigationId +
                ", secondNavigationSequence=" + secondNavigationSequence +
                ", secondNavigationView=" + secondNavigationView +
                ", secondNavigationBarName='" + secondNavigationBarName + '\'' +
                ", secondNavigationCreateDate=" + secondNavigationCreateDate +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleCreateDate=" + articleCreateDate +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
