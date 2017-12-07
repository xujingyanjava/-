package com.yanblog.base.response;

/**
 * Created by xujingyan on 2016/12/14.
 */
public interface Response<T> {

    public int getCode();

    public String getMsg();

    public T getData();
}
