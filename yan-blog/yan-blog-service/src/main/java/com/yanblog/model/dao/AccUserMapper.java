package com.yanblog.model.dao;

import com.yanblog.model.domain.AccUser;
import com.yanblog.model.domain.AccUserExample;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


public interface AccUserMapper {
    int countByExample(AccUserExample example);

    int deleteByPrimaryKey(Long accUserId);

    int insert(AccUser record);

    int insertSelective(AccUser record);

    List<AccUser> selectByExample(AccUserExample example);

    AccUser selectByPrimaryKey(Long accUserId);

    int updateByPrimaryKeySelective(AccUser record);

    int updateByPrimaryKey(AccUser record);
}