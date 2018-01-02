package com.yanblog.controller;

import com.yanblog.base.Pagination;
import com.yanblog.base.constans.ResponEnumes;
import com.yanblog.base.response.JsonResponse;
import com.yanblog.base.utils.JSONUtils;
import com.yanblog.model.domain.AccUser;
import com.yanblog.model.domain.SnsCategory;
import com.yanblog.service.AccUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xujingyan on 2017/12/20.
 */
@RestController
public class AccUserController {

    @Autowired
    private AccUserService accUserService;


    /**
     * 获取用户信息
     * @param params
     * @return
     */
    @RequestMapping("/getAccUserInfo")
    public JsonResponse<Map<String, Object>> getAccUserInfo(String params) {
        JsonResponse<Map<String, Object>> jsonResponse = new JsonResponse<>();

        JSONObject jsonObject = JSONUtils.toJSONObject(params);
        if (jsonObject == null) {
            jsonResponse.setMsg(ResponEnumes.LACK_PARAMS.getDesc());
            jsonResponse.setCode(ResponEnumes.LACK_PARAMS.getCode());
            return jsonResponse;
        }

        Long accUserId = jsonObject.getLong("accUserId");
        if (accUserId == null) {
            jsonResponse.setMsg(ResponEnumes.LACK_PARAMS.getDesc());
            jsonResponse.setCode(ResponEnumes.LACK_PARAMS.getCode());
            return jsonResponse;
        }
        AccUser accUser = accUserService.selectByPrimaryKey(accUserId);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("accUserIndo", accUser);

        jsonResponse.setMsg(ResponEnumes.Success.getDesc());
        jsonResponse.setCode(ResponEnumes.Success.getCode());
        jsonResponse.setData(returnMap);
        return jsonResponse;
    }
}
