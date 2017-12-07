package com.yanblog.model.dao;


import com.yanblog.model.domain.Article;
import com.yanblog.model.domain.ArticleExample;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    int count(Map<String, Object> param);

    List<Article> findList(Map<String, Object> param);
}