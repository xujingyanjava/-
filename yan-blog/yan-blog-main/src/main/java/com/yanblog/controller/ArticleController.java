package com.yanblog.controller;

import com.yanblog.base.constans.ResponEnumes;
import com.yanblog.base.response.JsonResponse;
import com.yanblog.model.domain.SnsArticle;
import com.yanblog.service.SnsArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xujingyan on 2017/12/13.
 */
@RestController
public class ArticleController {

    @Autowired
    private SnsArticleService snsArticleService;
    @RequestMapping("/getArticleInfo")
    public JsonResponse<Map<String,Object>> getArticleInfo(HttpServletRequest servletRequest,HttpServletResponse servletResponse){
        JsonResponse<Map<String,Object>> jsonResponse=new JsonResponse<>();
        String snsArticleId=servletRequest.getParameter("snsArticleId");
        if(StringUtils.isBlank(snsArticleId)){
            jsonResponse.setCode(ResponEnumes.LACK_PARAMS.getCode());
            jsonResponse.setMsg(ResponEnumes.LACK_PARAMS.getDesc());
            return jsonResponse;
        }
        SnsArticle snsArticle=snsArticleService.selectByPrimaryKey(Long.parseLong(snsArticleId));
        if(snsArticle==null){
            jsonResponse.setCode(ResponEnumes.LACK_PARAMS.getCode());
            jsonResponse.setMsg(ResponEnumes.LACK_PARAMS.getDesc());
            return jsonResponse;
        }
        Map<String,Object> params=new HashMap<>();
        params.put("snsArticleId",snsArticle.getSnsArticleId());
        jsonResponse.setData(params);
//        jsonResponse.setMsg(ResponEnumes.Success.getDesc());
//        jsonResponse.setCode(ResponEnumes.Success.getCode());
        return jsonResponse;
    }
}
