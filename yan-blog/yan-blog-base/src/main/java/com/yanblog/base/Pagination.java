package com.yanblog.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xujingyan on 2017/1/6.
 *
 * 分页
 */
public class Pagination<T> implements Serializable {

    private int pageNo=1;

    private int pageSize=10;

    private int totalPageNo=1;

    private int totalPageSize=0;

    private List<T> dataList;

    private int startIndex;

    private int endIndex;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public int getStartIndex() {
        this.startIndex=(pageNo-1)*pageSize;
        return startIndex;
    }

    public int getEndIndex() {
        return pageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        if(totalPageSize==0){
            this.totalPageNo=1;
        }else {
            this.totalPageNo=(int) Math.ceil(new Double(totalPageSize) / pageSize);
        }
        this.totalPageSize = totalPageSize;
    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
