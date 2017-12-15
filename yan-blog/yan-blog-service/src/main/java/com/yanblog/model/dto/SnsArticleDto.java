package com.yanblog.model.dto;

import java.io.Serializable;
import java.util.Date;

public class SnsArticleDto implements Serializable{
    private Long snsArticleId;

    private String author;

    private Long accUserId;

    private String title;

    private String content;

    private String coverImage;

    private Byte status;

    private Byte deleteFlag;

    private Date createTime;

    private Date lastTime;

    public Long getSnsArticleId() {
        return snsArticleId;
    }

    public void setSnsArticleId(Long snsArticleId) {
        this.snsArticleId = snsArticleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getAccUserId() {
        return accUserId;
    }

    public void setAccUserId(Long accUserId) {
        this.accUserId = accUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}