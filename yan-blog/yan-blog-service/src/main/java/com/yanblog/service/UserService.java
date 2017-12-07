package com.yanblog.service;


import com.yanblog.base.response.JsonResponse;
import com.yanblog.model.domain.UserInfo;

/**
 * Created by xujingyan on 2016/12/9.
 */
public interface UserService {

    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    public JsonResponse registerUser(String userName, String password);

    public JsonResponse login(String userName, String password);
}
