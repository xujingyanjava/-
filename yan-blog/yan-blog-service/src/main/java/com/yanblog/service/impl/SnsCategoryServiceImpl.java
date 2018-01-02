package com.yanblog.service.impl;

import com.yanblog.base.Pagination;
import com.yanblog.model.dao.SnsCategoryMapper;
import com.yanblog.model.domain.SnsCategory;
import com.yanblog.model.domain.SnsCategoryExample;
import com.yanblog.model.dto.SnsArticleDto;
import com.yanblog.service.SnsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xujingyan on 2017/12/20.
 */
@Service
public class SnsCategoryServiceImpl implements SnsCategoryService {

    @Autowired
    private SnsCategoryMapper snsCategoryMapper;

    @Override
    public int countByExample(SnsCategoryExample example) {
        return snsCategoryMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long snsCategoryId) {
        return snsCategoryMapper.deleteByPrimaryKey(snsCategoryId);
    }

    @Override
    public int insert(SnsCategory record) {
        return snsCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(SnsCategory record) {
        return snsCategoryMapper.insertSelective(record);
    }

    @Override
    public List<SnsCategory> selectByExample(SnsCategoryExample example) {
        return snsCategoryMapper.selectByExample(example);
    }

    @Override
    public SnsCategory selectByPrimaryKey(Long snsCategoryId) {
        return snsCategoryMapper.selectByPrimaryKey(snsCategoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(SnsCategory record) {
        return snsCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SnsCategory record) {
        return snsCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<SnsCategory> findPage(int pageNum, int pageSize, Map<String, Object> params) {
        if(params==null){
            params=new HashMap<>();
        }
        int counrNumber=snsCategoryMapper.count(params);
        Pagination pagination=new Pagination();
        pagination.setTotalPageSize(counrNumber);
        pagination.setPageNo(pageNum);
        pagination.setPageSize(pageSize);
        params.put("startIndex", pagination.getStartIndex());
        params.put("endIndex",pagination.getEndIndex());
        List<SnsCategory> snsArticleDtoList = snsCategoryMapper.selectAll(params);
        pagination.setDataList(snsArticleDtoList);
        return pagination;
    }

}
