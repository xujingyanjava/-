package com.yanblog.service;

import com.github.pagehelper.PageInfo;
import com.yanblog.base.Pagination;
import com.yanblog.model.domain.SnsArticle;
import com.yanblog.model.domain.SnsArticleExample;
import com.yanblog.model.dto.SnsArticleDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    Pagination<SnsArticleDto> findPage(int pageNum,int pageSize,Map<String,Object> params);

}
