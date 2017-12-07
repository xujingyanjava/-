package com.yanblog.service.impl;

import com.yanblog.model.dao.ArticleTypeMapper;
import com.yanblog.model.domain.ArticleType;
import com.yanblog.model.domain.ArticleTypeExample;
import com.yanblog.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xujingyan on 2017/1/14.
 */
@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public int countByExample(ArticleTypeExample example) {
        return articleTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleTypeExample example) {
        return articleTypeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer articleTypeId) {
        return articleTypeMapper.deleteByPrimaryKey(articleTypeId);
    }

    @Override
    public int insert(ArticleType record) {
        return articleTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleType record) {
        return articleTypeMapper.insertSelective(record);
    }

    @Override
    public List<ArticleType> selectByExample(ArticleTypeExample example) {
        return articleTypeMapper.selectByExample(example);
    }

    @Override
    public ArticleType selectByPrimaryKey(Integer articleTypeId) {
        return articleTypeMapper.selectByPrimaryKey(articleTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleType record) {
        return articleTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ArticleType record) {
        return articleTypeMapper.updateByPrimaryKey(record);
    }
}
