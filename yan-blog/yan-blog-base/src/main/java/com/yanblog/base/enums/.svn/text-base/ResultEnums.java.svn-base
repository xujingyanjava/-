package com.yanblog.base.enums;

/**
 * Created by xujingyan on 2016/12/15.
 */
public enum ResultEnums {
    /**1开头用户级别  2用户模块返回**/
    Success("成功",200),
    Fail("失败",1002),
    Error_Parames_Null("参数不能为空",1003),
    UserNameIsExist("用户名已存在",2001),
    RegisterSuccess("注册成功",2002),
    UserNameOrPwdError("用户名或密码错误",2003),
    UserLoginSuccess("登陆成功",2004),
    UserLoginFail("登陆失败",2005),
    ;

    ResultEnums(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    private String msg;

    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
