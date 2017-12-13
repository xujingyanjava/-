package com.yanblog.service;

import com.yanblog.model.domain.AccUser;
import com.yanblog.model.domain.AccUserExample;

import java.util.List;

/**
 * Created by xujingyan on 2017/12/13.
 */
public interface AccUserService {

    int countByExample(AccUserExample example);

    int deleteByPrimaryKey(Long accUserId);

    int insert(AccUser record);

    int insertSelective(AccUser record);

    List<AccUser> selectByExample(AccUserExample example);

    AccUser selectByPrimaryKey(Long accUserId);

    int updateByPrimaryKeySelective(AccUser record);

    int updateByPrimaryKey(AccUser record);

}
