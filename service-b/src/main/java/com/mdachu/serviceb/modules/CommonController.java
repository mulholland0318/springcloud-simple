package com.mdachu.serviceb.modules;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @RequestMapping("/helloworld")
    private String helloworld(){
        return "helloWorld111";
    }
}
