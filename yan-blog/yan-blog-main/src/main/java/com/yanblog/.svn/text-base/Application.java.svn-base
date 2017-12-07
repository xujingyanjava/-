package com.yanblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujingyan on 2017/10/25.
 */
@SpringBootApplication
@RestController
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application implements EmbeddedServletContainerCustomizer {

    @RequestMapping("/")
    public String test(){
        return "hello 365 World";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(365);
    }
}
