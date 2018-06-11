package com.mdachu.servera.servicea.modules;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @RequestMapping("/helloworld")
    public String helloworld(){
        return "helloWorld2222";
    }


    @RequestMapping("/helloparam")
    public String helloparam(String name){
        return "hello "+ name;
    }

    @RequestMapping("/helloobj")
    public String helloobj(User user){
        return user.getName() + user.getAge() + user.getId();
    }
}
