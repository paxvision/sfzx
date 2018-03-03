package com.geek.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuanyang
 */
public class Content {

    //内容编号,自增
    private Integer contentId;
    //内容题目
    private String contentTitle;
    //主要内容
    private String mainContent;
    //内容所属栏目,默认为根栏目0
    private Integer contentPart = 0;
    //内容是否呈现,1呈现,0不呈现,默认为1
    private Integer contentDisplay = 1;
    //内容是否为公告,1是,0不是,默认为0
    private Integer contentNotice = 0;
    //添加时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date contentTime;
    //查看次数
    private Integer contentView;

    public Content() {
    }

    public Content(Integer contentId, String contentTitle, String mainContent, Integer contentPart, Integer contentDisplay, Integer contentNotice, Date contentTime, Integer contentView) {
        this.contentId = contentId;
        this.contentTitle = contentTitle;
        this.mainContent = mainContent;
        this.contentPart = contentPart;
        this.contentDisplay = contentDisplay;
        this.contentNotice = contentNotice;
        this.contentTime = contentTime;
        this.contentView = contentView;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public Integer getContentPart() {
        return contentPart;
    }

    public void setContentPart(Integer contentPart) {
        this.contentPart = contentPart;
    }

    public Integer getContentDisplay() {
        return contentDisplay;
    }

    public void setContentDisplay(Integer contentDisplay) {
        this.contentDisplay = contentDisplay;
    }

    public Integer getContentNotice() {
        return contentNotice;
    }

    public void setContentNotice(Integer contentNotice) {
        this.contentNotice = contentNotice;
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }

    public Integer getContentView() {
        return contentView;
    }

    public void setContentView(Integer contentView) {
        this.contentView = contentView;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", contentTitle='" + contentTitle + '\'' +
                ", mainContent='" + mainContent + '\'' +
                ", contentPart=" + contentPart +
                ", contentDisplay=" + contentDisplay +
                ", contentNotice=" + contentNotice +
                ", contentTime=" + contentTime +
                ", contentView=" + contentView +
                '}';
    }
}
