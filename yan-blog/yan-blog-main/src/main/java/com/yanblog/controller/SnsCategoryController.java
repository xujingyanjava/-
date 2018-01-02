package com.yanblog.controller;

import com.yanblog.base.Pagination;
import com.yanblog.base.constans.ResponEnumes;
import com.yanblog.base.response.JsonResponse;
import com.yanblog.model.domain.SnsCategory;
import com.yanblog.service.SnsArticleCategoryService;
import com.yanblog.service.SnsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xujingyan on 2017/12/19.
 */
@RestController
public class SnsCategoryController {

    @Autowired
    private SnsArticleCategoryService snsArticleCategoryService;

    @Autowired
    private SnsCategoryService snsCategoryService;


    /**
     * 获取分类
     *
     * @return
     */
    @RequestMapping("/getSnsCateGoryList")
    public JsonResponse<Map<String, Object>> getSnsCateGoryList() {
        JsonResponse<Map<String, Object>> jsonResponse = new JsonResponse<>();

        Pagination<SnsCategory> snsCategoryList = snsCategoryService.findPage(1, 10, null);

        Map<String, Object> params = new HashMap<>();
        params.put("snsCategoryList", snsCategoryList);

        jsonResponse.setMsg(ResponEnumes.Success.getDesc());
        jsonResponse.setCode(ResponEnumes.Success.getCode());
        jsonResponse.setData(params);
        return jsonResponse;
    }

}
