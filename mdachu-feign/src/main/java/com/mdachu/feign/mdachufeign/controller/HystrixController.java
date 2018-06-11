package com.mdachu.feign.mdachufeign.controller;

import com.mdachu.feign.mdachufeign.service.HelloWorldService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HystrixController {


    @Autowired
    private HelloWorldService service;

    @RequestMapping(value = "/fallback",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getFallback")
    public String getHystrix(String p){
        if("p".equals(p)){
            throw new RuntimeException("部门信息不存在！");
        }
        return "hystrix";
    }

    public String getFallback(String p){
        return "fallbackHystrix";
    }


    @RequestMapping("/test")
    public String test(){
        return service.helloworld();
    }


    @RequestMapping("/timeouttest")
    @HystrixCommand(fallbackMethod = "timeoutMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")
    })
    public String timeoutmethod(){
        Random random = new Random();
        int randomSleep = random.nextInt(3000);
        System.out.println("the sleep time is :"+randomSleep);
        try {
            Thread.sleep(randomSleep);
        } catch (InterruptedException e) {

            System.out.println("there is something wrong with the thread sleep");
        }
        return "notimeout";
    }


    public String timeoutMethod(){
        return "timeout";
    }


    @RequestMapping("present")
    @HystrixCommand(fallbackMethod = "presentMethod", commandProperties = {
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public String prestentTest(){
        Random rand = new Random();
        int randNum = rand.nextInt(1000);
        if(randNum%2 == 0 && randNum< 10){
            return "ok";
        }else {
            while(true){
                int j = 1;
                j++;
            }
        }

    }


    public String presentMethod(){
        return "presentWrong";
    }
}
