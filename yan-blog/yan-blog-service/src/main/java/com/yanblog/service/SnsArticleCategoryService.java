package com.yanblog.service;

import com.yanblog.model.domain.SnsArticleCategory;
import com.yanblog.model.domain.SnsArticleCategoryExample;

import java.util.List;

/**
 * Created by xujingyan on 2017/12/13.
 */
public interface SnsArticleCategoryService {
    int countByExample(SnsArticleCategoryExample example);

    int deleteByPrimaryKey(Long snsArticleCategoryId);

    int insert(SnsArticleCategory record);

    int insertSelective(SnsArticleCategory record);

    List<SnsArticleCategory> selectByExample(SnsArticleCategoryExample example);

    SnsArticleCategory selectByPrimaryKey(Long snsArticleCategoryId);

    int updateByPrimaryKeySelective(SnsArticleCategory record);

    int updateByPrimaryKey(SnsArticleCategory record);
}
