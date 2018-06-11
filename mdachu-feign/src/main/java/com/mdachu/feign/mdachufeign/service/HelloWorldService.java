package com.mdachu.feign.mdachufeign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "server")
public interface HelloWorldService {

    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)
    public String helloworld();

    static class HelloWorldFallBack implements HystrixClient{

    }





}

