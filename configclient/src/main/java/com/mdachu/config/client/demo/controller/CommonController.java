package com.mdachu.config.client.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RefreshScope /// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中
@RestController

public class CommonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${name}")
    private String test;

    @RequestMapping("/test")
    public Object test(){

        return this.test+ System.currentTimeMillis();
    }

    @RequestMapping("/findInfo")
    public String findInfo(){
        return this.restTemplate.getForObject("http://server/helloworld",String.class);
    }

    @RequestMapping("/find")
    public String find(){
        Map param = new HashMap();
        param.put("name","name");
        return this.restTemplate.getForObject("http://server/helloparam",String.class,param);
    }

    @RequestMapping("/findobj")
    public String findobj(){
        User user = new User();
        user.setAge((short) 100);
        user.setName("zhangsan");
        user.setId(123);
        return this.restTemplate.getForObject("http://server/helloobj",String.class,user);
    }
}
