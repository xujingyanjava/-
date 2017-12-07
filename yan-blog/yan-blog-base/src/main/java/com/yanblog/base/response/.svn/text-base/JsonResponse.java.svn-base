package com.yanblog.base.response;

import java.io.Serializable;

/**
 * Created by xujingyan on 2016/12/14.
 */
public class JsonResponse<T> implements Response ,Serializable {

    private Integer code;

    private T data;

    private String msg;


    public JsonResponse(){

    }

    public JsonResponse(int code, T data, String msg) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Object getData() {
        return data;
    }
}
