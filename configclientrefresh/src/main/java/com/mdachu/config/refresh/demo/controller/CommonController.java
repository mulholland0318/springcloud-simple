package com.mdachu.config.refresh.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CommonController {

    @Value("${name}")
    private String test;

    @RequestMapping("/test")
    public String test(){
        return this.test + "/ " +System.currentTimeMillis();
    }
}
