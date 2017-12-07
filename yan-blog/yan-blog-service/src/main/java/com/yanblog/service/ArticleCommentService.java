package com.yanblog.service;



import com.yanblog.base.Pagination;
import com.yanblog.model.domain.ArticleComment;
import com.yanblog.model.domain.ArticleCommentExample;
import com.yanblog.model.dto.ArticleCommentDto;

import java.util.List;

/**
 * Created by xujingyan on 2017/1/18.
 */
public interface ArticleCommentService {

    int countByExample(ArticleCommentExample example);

    int deleteByExample(ArticleCommentExample example);

    int deleteByPrimaryKey(Long articleCommentId);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long articleCommentId);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);

    Pagination<ArticleCommentDto> findPage(Integer pageNo, Integer pageSize, Long articleId);
}
