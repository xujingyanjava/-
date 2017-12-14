package com.yanblog.model.dao;

import com.yanblog.model.domain.SnsArticle;
import com.yanblog.model.domain.SnsArticleExample;

import java.util.List;


public interface SnsArticleMapper {
    int countByExample(SnsArticleExample example);

    int deleteByPrimaryKey(Long snsArticle);

    int insert(SnsArticle record);

    int insertSelective(SnsArticle record);

    List<SnsArticle> selectByExample(SnsArticleExample example);

    SnsArticle selectByPrimaryKey(Long snsArticle);

    int updateByPrimaryKeySelective(SnsArticle record);

    int updateByPrimaryKey(SnsArticle record);
}