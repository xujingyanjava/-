package com.yanblog.controller;

import com.yanblog.base.Pagination;
import com.yanblog.base.constans.ResponEnumes;
import com.yanblog.base.response.JsonResponse;
import com.yanblog.base.utils.JSONUtils;
import com.yanblog.model.domain.SnsArticle;
import com.yanblog.model.dto.SnsArticleDto;
import com.yanblog.service.SnsArticleService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public JsonResponse<Map<String,Object>> getArticleInfo(String params){
        JsonResponse<Map<String,Object>> jsonResponse=new JsonResponse<>();

        JSONObject obj = JSONUtils.toJSONObject(params);
        if(obj==null){
            jsonResponse.setCode(ResponEnumes.LACK_PARAMS.getCode());
            jsonResponse.setMsg(ResponEnumes.LACK_PARAMS.getDesc());
            return jsonResponse;
        }

        String snsArticleId=obj.getString("snsArticleId");
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
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("snsArticleId",snsArticle.getSnsArticleId());
        jsonResponse.setData(resultMap);
        jsonResponse.setMsg(ResponEnumes.Success.getDesc());
        jsonResponse.setCode(ResponEnumes.Success.getCode());
        return jsonResponse;
    }

    @RequestMapping("/getArticleList")
    public JsonResponse<Map<String,Object>> getArticleList(String params,
                                                           @RequestParam(value = "pageNum", required = false, defaultValue="1") Integer pageNum,
                                                           @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize
                                                          ){

       JSONObject jsonObject= JSONUtils.toJSONObject(params);

        Map<String,Object> selectParams=new HashMap<>();

        if(jsonObject!=null){
            Long snsCategoryId=jsonObject.getLong("snsCategoryId");
            if(snsCategoryId!=null){
                selectParams.put("snsCategoryId",snsCategoryId);
            }
        }
        JsonResponse<Map<String,Object>> jsonResponse=new JsonResponse<>();

        Pagination<SnsArticleDto> pagination = snsArticleService.findPage(pageNum,pageSize,selectParams);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("list",pagination);
        jsonResponse.setData(resultMap);
        jsonResponse.setMsg(ResponEnumes.Success.getDesc());
        jsonResponse.setCode(ResponEnumes.Success.getCode());
        return jsonResponse;
    }

}
