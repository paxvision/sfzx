package com.geek.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuanyang
 */
public class SourceFile {

    //图片编号,自增
    private Integer fileId;
    //图片名称
    private String fileName;
    //图片虚拟地址
    private String filePath;
    //图片类型
    private String fileType;
    //图片大小
    private Integer fileSize;
    //图片插入时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fileTime;

    public SourceFile() {
    }

    public SourceFile(Integer fileId, String fileName, String filePath, String fileType, Integer fileSize, Date fileTime) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.fileTime = fileTime;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Date getFileTime() {
        return fileTime;
    }

    public void setFileTime(Date fileTime) {
        this.fileTime = fileTime;
    }

    @Override
    public String toString() {
        return "SourceFile{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize=" + fileSize +
                ", fileTime=" + fileTime +
                '}';
    }
}
