package com.yanblog.model.dao;

import com.yanblog.model.domain.SnsCategory;
import com.yanblog.model.domain.SnsCategoryExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SnsCategoryMapper {
    int countByExample(SnsCategoryExample example);

    int deleteByPrimaryKey(Long snsCategoryId);

    int insert(SnsCategory record);

    int insertSelective(SnsCategory record);

    List<SnsCategory> selectByExample(SnsCategoryExample example);

    SnsCategory selectByPrimaryKey(Long snsCategoryId);

    int updateByPrimaryKeySelective(SnsCategory record);

    int updateByPrimaryKey(SnsCategory record);
}