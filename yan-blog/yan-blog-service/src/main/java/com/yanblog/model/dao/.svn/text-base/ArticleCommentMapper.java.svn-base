package com.yanblog.model.dao;



import com.yanblog.model.domain.ArticleComment;
import com.yanblog.model.domain.ArticleCommentExample;
import com.yanblog.model.dto.ArticleCommentDto;

import java.util.List;
import java.util.Map;

public interface ArticleCommentMapper {
    int countByExample(ArticleCommentExample example);

    int deleteByExample(ArticleCommentExample example);

    int deleteByPrimaryKey(Long articleCommentId);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long articleCommentId);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);

    int count(Map<String, Object> param);

    List<ArticleCommentDto> findArticleCommentList(Map<String, Object> param);
}