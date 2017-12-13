package com.yanblog.model.dao;

import com.yanblog.model.domain.SnsArticleCategory;
import com.yanblog.model.domain.SnsArticleCategoryExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SnsArticleCategoryMapper {
    int countByExample(SnsArticleCategoryExample example);

    int deleteByPrimaryKey(Long snsArticleCategoryId);

    int insert(SnsArticleCategory record);

    int insertSelective(SnsArticleCategory record);

    List<SnsArticleCategory> selectByExample(SnsArticleCategoryExample example);

    SnsArticleCategory selectByPrimaryKey(Long snsArticleCategoryId);

    int updateByPrimaryKeySelective(SnsArticleCategory record);

    int updateByPrimaryKey(SnsArticleCategory record);
}