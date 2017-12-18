package com.yanblog.model.dao;

import com.yanblog.model.domain.SnsArticle;
import com.yanblog.model.domain.SnsArticleExample;
import com.yanblog.model.dto.SnsArticleDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface SnsArticleMapper {
    int countByExample(SnsArticleExample example);

    int deleteByPrimaryKey(Long snsArticle);

    int insert(SnsArticle record);

    int insertSelective(SnsArticle record);

    List<SnsArticle> selectByExample(SnsArticleExample example);

    SnsArticle selectByPrimaryKey(Long snsArticle);

    int updateByPrimaryKeySelective(SnsArticle record);

    int updateByPrimaryKey(SnsArticle record);

    List<SnsArticleDto> selectAll(Map<String, Object> params);

    int count(Map<String,Object> params);
}