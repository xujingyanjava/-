package com.yanblog.service.impl;


import com.yanblog.base.Pagination;
import com.yanblog.model.dao.ArticleMapper;
import com.yanblog.model.domain.Article;
import com.yanblog.model.domain.ArticleExample;
import com.yanblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xujingyan on 2016/12/15.
 */

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int countByExample(ArticleExample example) {
        return articleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleExample example) {
        return articleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long articleId) {
        return articleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public int insert(Article record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(Article record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public List<Article> selectByExample(ArticleExample example) {
        return articleMapper.selectByExample(example);
    }

    @Override
    public Article selectByPrimaryKey(Long articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return articleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<Article> findPage(int pageNo,int pageSize,Integer isHot,Integer isRecommend,Long articleTypeId) {
        Pagination<Article> pagination=new Pagination<Article>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        Map<String,Object> param=new HashMap<String, Object>();
        if(isHot!=null){
            param.put("isHot",isHot);
        }
        if(isRecommend!=null){
            param.put("isRecommend",isRecommend);
        }
        if(articleTypeId!=null){
            param.put("articleTypeId",articleTypeId);
        }
        int count=articleMapper.count(param);
        if(count<0){
            return pagination;
        }
        pagination.setTotalPageSize(count);
        param.put("startIndex",pagination.getStartIndex());
        param.put("endIndex",pagination.getEndIndex());
        List<Article> articles=articleMapper.findList(param);
        pagination.setDataList(articles);
        return pagination;
    }
}
