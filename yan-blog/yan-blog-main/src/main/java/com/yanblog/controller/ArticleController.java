package com.yanblog.controller;

import com.yanblog.model.domain.AccUser;
import com.yanblog.model.domain.SnsArticle;
import com.yanblog.service.AccUserService;
import com.yanblog.service.SnsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujingyan on 2017/12/13.
 */
@RestController
public class ArticleController {

    @Autowired
    private SnsArticleService snsArticleService;
    @RequestMapping("/getArticleInfo")
    public String getArticleInfo(){
        SnsArticle snsArticle=snsArticleService.selectByPrimaryKey(1L);
        return "123456";
    }
}
