package com.yanblog.model.domain;

import java.util.Date;

public class SnsCategory {
    private Long snsCategoryId;

    private String snsCategoryName;

    private Long lastSnsCategoryId;

    private Byte type;

    private Date createTime;

    private Date lastTime;

    public Long getSnsCategoryId() {
        return snsCategoryId;
    }

    public void setSnsCategoryId(Long snsCategoryId) {
        this.snsCategoryId = snsCategoryId;
    }

    public String getSnsCategoryName() {
        return snsCategoryName;
    }

    public void setSnsCategoryName(String snsCategoryName) {
        this.snsCategoryName = snsCategoryName;
    }

    public Long getLastSnsCategoryId() {
        return lastSnsCategoryId;
    }

    public void setLastSnsCategoryId(Long lastSnsCategoryId) {
        this.lastSnsCategoryId = lastSnsCategoryId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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