package com.yanblog.base;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by xujingyan on 2017/12/15.
 */
@Configuration
public class PageHelperConfiguration {

    private static final Logger log= LoggerFactory.getLogger(PageHelperConfiguration.class);

    @Bean
    public PageHelper pageHelper(){
        log.info("--------import org.apache.log4j.spi.LoggerFactory;");
        PageHelper pageHelper=new PageHelper();
        Properties properties=new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        //添加插件
        return pageHelper;
    }
}
