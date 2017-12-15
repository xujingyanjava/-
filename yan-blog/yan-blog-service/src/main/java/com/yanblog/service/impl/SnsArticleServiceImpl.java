package com.yanblog.service.impl;

import com.yanblog.model.dao.SnsArticleMapper;
import com.yanblog.model.domain.SnsArticle;
import com.yanblog.model.domain.SnsArticleExample;
import com.yanblog.model.dto.SnsArticleDto;
import com.yanblog.service.SnsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xujingyan on 2017/12/13.
 */
@Service
public class SnsArticleServiceImpl implements SnsArticleService {

    @Autowired
    private SnsArticleMapper snsArticleMapper;

    @Override
    public int countByExample(SnsArticleExample example) {
        return snsArticleMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long snsArticle) {
        return snsArticleMapper.deleteByPrimaryKey(snsArticle);
    }

    @Override
    public int insert(SnsArticle record) {
        return snsArticleMapper.insert(record);
    }

    @Override
    public int insertSelective(SnsArticle record) {
        return snsArticleMapper.insertSelective(record);
    }

    @Override
    public List<SnsArticle> selectByExample(SnsArticleExample example) {
        return snsArticleMapper.selectByExample(example);
    }

    @Override
    public SnsArticle selectByPrimaryKey(Long snsArticle) {
        return snsArticleMapper.selectByPrimaryKey(snsArticle);
    }

    @Override
    public int updateByPrimaryKeySelective(SnsArticle record) {
        return snsArticleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SnsArticle record) {
        return snsArticleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SnsArticleDto> findPage(Map<String, Object> params) {

        return null;
    }
}
