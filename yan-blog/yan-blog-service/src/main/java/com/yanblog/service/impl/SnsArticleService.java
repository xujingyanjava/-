package com.yanblog.service.impl;

import com.yanblog.model.domain.SnsArticle;
import com.yanblog.model.domain.SnsArticleExample;

import java.util.List;

/**
 * Created by xujingyan on 2017/12/13.
 */
public interface SnsArticleService {

    int countByExample(SnsArticleExample example);

    int deleteByPrimaryKey(Long snsArticle);

    int insert(SnsArticle record);

    int insertSelective(SnsArticle record);

    List<SnsArticle> selectByExample(SnsArticleExample example);

    SnsArticle selectByPrimaryKey(Long snsArticle);

    int updateByPrimaryKeySelective(SnsArticle record);

    int updateByPrimaryKey(SnsArticle record);

}
