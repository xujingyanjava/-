package com.yanblog.service.impl;

import com.yanblog.model.dao.SnsArticleCategoryMapper;
import com.yanblog.model.domain.SnsArticleCategory;
import com.yanblog.model.domain.SnsArticleCategoryExample;
import com.yanblog.service.SnsArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xujingyan on 2017/12/13.
 */
@Service
public class SnsArticleCategoryServiceImpl implements SnsArticleCategoryService {

    @Autowired
    private SnsArticleCategoryMapper snsArticleCategoryMapper;

    @Override
    public int countByExample(SnsArticleCategoryExample example) {
        return snsArticleCategoryMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long snsArticleCategoryId) {
        return snsArticleCategoryMapper.deleteByPrimaryKey(snsArticleCategoryId);
    }

    @Override
    public int insert(SnsArticleCategory record) {
        return snsArticleCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(SnsArticleCategory record) {
        return snsArticleCategoryMapper.insertSelective(record);
    }

    @Override
    public List<SnsArticleCategory> selectByExample(SnsArticleCategoryExample example) {
        return snsArticleCategoryMapper.selectByExample(example);
    }

    @Override
    public SnsArticleCategory selectByPrimaryKey(Long snsArticleCategoryId) {
        return snsArticleCategoryMapper.selectByPrimaryKey(snsArticleCategoryId);
    }

    @Override
    public int updateByPrimaryKeySelective(SnsArticleCategory record) {
        return snsArticleCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SnsArticleCategory record) {
        return snsArticleCategoryMapper.updateByPrimaryKey(record);
    }
}
