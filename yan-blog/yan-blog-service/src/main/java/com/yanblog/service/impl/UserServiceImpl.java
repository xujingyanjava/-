package com.yanblog.service.impl;


import com.yanblog.base.enums.RedisKeyEnum;
import com.yanblog.base.enums.ResultEnums;
import com.yanblog.base.response.JsonResponse;
import com.yanblog.base.utils.MD5Util;
import com.yanblog.base.utils.RandomGUIDUtil;
import com.yanblog.base.utils.redis.RedisUtils;
import com.yanblog.base.utils.redis.SerializeUtil;
import com.yanblog.model.dao.UserInfoMapper;
import com.yanblog.model.domain.UserInfo;
import com.yanblog.model.domain.UserInfoExample;
import com.yanblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-12-10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Long userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public JsonResponse registerUser(String userName, String password) {
        JsonResponse response=new JsonResponse();
        try {
            UserInfoExample userInfoExample=new UserInfoExample();
            userInfoExample.createCriteria().andUserNameEqualTo(userName);
            int i=userInfoMapper.countByExample(userInfoExample);
            if(i>0){//用户存在直接返回
                response.setMsg(ResultEnums.UserNameIsExist.getMsg());
                response.setCode(ResultEnums.Success.getCode());
                return response;
            }
            UserInfo userInfo=new UserInfo();
            userInfo.setUserName(userName);
            userInfo.setUserPassword(MD5Util.EncodeMD5Hex(password));
            Date date=new Date();
            userInfo.setCreateTime(date);
            userInfo.setUpdateTime(date);
            userInfo.setRegisterTime(date);
            userInfo.setLoginTime(date);
            userInfoMapper.insertSelective(userInfo);
            response.setMsg(ResultEnums.RegisterSuccess.getMsg());
            response.setCode(ResultEnums.Success.getCode());
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            response.setMsg(ResultEnums.Fail.getMsg());
            response.setCode(ResultEnums.Fail.getCode());
            return response;
        }
    }

    @Override
    public JsonResponse login(String userName, String password) {
        JsonResponse response=new JsonResponse();
        try{
            UserInfoExample userInfoExample=new UserInfoExample();
            userInfoExample.createCriteria().andUserNameEqualTo(userName).andUserPasswordEqualTo(MD5Util.EncodeMD5Hex(password));
            List<UserInfo> userInfoList=userInfoMapper.selectByExample(userInfoExample);
            if(CollectionUtils.isEmpty(userInfoList)){
                response.setCode(ResultEnums.UserNameOrPwdError.getCode());
                response.setMsg(ResultEnums.UserNameOrPwdError.getMsg());
                return response;
            }
            UserInfo userInfo=userInfoList.get(0);
            Map<String,Object> returnMap=new HashMap<String, Object>();
            returnMap.put("userName",userInfo.getUserName());
            returnMap.put("userId", userInfo.getUserId());
            String userToken = MD5Util.EncodeMD5Hex(userInfo.getUserId() + RandomGUIDUtil.getRandomString(32));
            RedisUtils.getInstance().set(RedisKeyEnum.user_info_+userToken, SerializeUtil.serialize(returnMap).toString());
            response.setCode(ResultEnums.Success.getCode());
            response.setMsg(ResultEnums.UserLoginSuccess.getMsg());
            response.setData(userToken);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            response.setMsg(ResultEnums.Fail.getMsg());
            response.setCode(ResultEnums.Fail.getCode());
            return response;
        }
    }
}
