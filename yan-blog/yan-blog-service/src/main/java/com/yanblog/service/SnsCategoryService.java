package com.yanblog.service;

import com.yanblog.base.Pagination;
import com.yanblog.model.domain.SnsCategory;
import com.yanblog.model.domain.SnsCategoryExample;

import java.util.List;
import java.util.Map;

/**
 * Created by xujingyan on 2017/12/20.
 */
public interface SnsCategoryService {

    int countByExample(SnsCategoryExample example);

    int deleteByPrimaryKey(Long snsCategoryId);

    int insert(SnsCategory record);

    int insertSelective(SnsCategory record);

    List<SnsCategory> selectByExample(SnsCategoryExample example);

    SnsCategory selectByPrimaryKey(Long snsCategoryId);

    int updateByPrimaryKeySelective(SnsCategory record);

    int updateByPrimaryKey(SnsCategory record);

    Pagination<SnsCategory> findPage(int pageNum,int pageSize,Map<String,Object> params);

}
