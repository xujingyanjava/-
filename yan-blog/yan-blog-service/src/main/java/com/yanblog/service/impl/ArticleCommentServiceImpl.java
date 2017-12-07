package com.yanblog.service.impl;


import com.yanblog.base.Pagination;
import com.yanblog.model.dao.ArticleCommentMapper;
import com.yanblog.model.domain.ArticleComment;
import com.yanblog.model.domain.ArticleCommentExample;
import com.yanblog.model.dto.ArticleCommentDto;
import com.yanblog.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xujingyan on 2017/1/18.
 */
@Service("articleCommentServiceImpl")
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;


    @Override
    public int countByExample(ArticleCommentExample example) {
        return articleCommentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ArticleCommentExample example) {
        return articleCommentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long articleCommentId) {
        return articleCommentMapper.deleteByPrimaryKey(articleCommentId);
    }

    @Override
    public int insert(ArticleComment record) {
        return articleCommentMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticleComment record) {
        return articleCommentMapper.insertSelective(record);
    }

    @Override
    public List<ArticleComment> selectByExample(ArticleCommentExample example) {
        return articleCommentMapper.selectByExample(example);
    }

    @Override
    public ArticleComment selectByPrimaryKey(Long articleCommentId) {
        return articleCommentMapper.selectByPrimaryKey(articleCommentId);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticleComment record) {
        return articleCommentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ArticleComment record) {
        return articleCommentMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<ArticleCommentDto> findPage(Integer pageNo, Integer pageSize, Long articleId) {
        Pagination<ArticleCommentDto> pagination=new Pagination<ArticleCommentDto>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        Map<String,Object> param=new HashMap<String, Object>();
        if(articleId!=null){
            param.put("articleId",articleId);
        }
        param.put("orderBy","ac.create_time desc");
        int count=articleCommentMapper.count(param);
        if(count<0){
            return pagination;
        }
        pagination.setTotalPageSize(count);
        param.put("startIndex",pagination.getStartIndex());
        param.put("endIndex",pagination.getEndIndex());
        List<ArticleCommentDto> articles=articleCommentMapper.findArticleCommentList(param);
        pagination.setDataList(articles);
        return pagination;
    }
}
