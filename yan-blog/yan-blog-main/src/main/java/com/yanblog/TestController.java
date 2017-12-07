package com.yanblog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujingyan on 2017/11/2.
 */
@RestController
public class TestController {

    @Value("${com.yan.blog.name}")
    private String name;

    @RequestMapping("/testaaa")
    public String testaaa(){
        return name;
    }
}
