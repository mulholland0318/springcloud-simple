package com.mdachu.web.mdachu_web.modules.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CommonController {

//    @Autowired
//    private RestTemplate restTemplate;


    @RequestMapping("/findInfo")
    public Object findInfo(){
        return "helloworld";
//        return restTemplate.getForObject("http://server/helloworld",String.class);
    }

}
