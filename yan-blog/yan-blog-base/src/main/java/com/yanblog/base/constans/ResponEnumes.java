package com.yanblog.base.constans;

/**
 * Created by xujingyan on 2017/12/14.
 */
public enum ResponEnumes {

    //系统级别 1 开头  自定义 2开头 其他特殊再单独定义

    Success(1001,"成功"),
    Fail(1002,"失败"),
    LACK_PARAMS(1003,"缺少参数"),

    ;

    private Integer code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ResponEnumes(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
