package com.yanblog.service;


import com.yanblog.base.Pagination;
import com.yanblog.model.domain.Article;
import com.yanblog.model.domain.ArticleExample;

import java.util.List;

/**
 * Created by xujingyan on 2016/12/15.
 */
public interface ArticleService {

    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    Pagination<Article> findPage(int pageNo, int PageSize, Integer isHot, Integer isRecommend, Long articleTypeId);

}
