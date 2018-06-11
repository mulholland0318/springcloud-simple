package com.mdachu.ordermodule.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(value="common urlApi",tags = {"通用方法","测试方法"},produces = "application/json",consumes = "application/xml",protocols = "http/1.1")
public class CommonController {


    @RequestMapping(value = "/swaggerTest" ,method = RequestMethod.GET)
    @ApiOperation(value="/swaggerTest",httpMethod = "Get",response = String.class,nickname = "SwaggerTest", code = 200,protocols = "http/1.1")
    @ApiResponses(
            @ApiResponse(code = 200, message = "swagger Test", response = String.class, responseContainer = "defaultContainer")
    )
    public String test(){
        return "swagger Test";
    }


    @ApiOperation(value="/callback",httpMethod = "post",response=String.class,code = 200)
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    public String callback(){
        return "callback";
    }

    @RequestMapping(value = "/swaggerparam" ,method = RequestMethod.GET)
    @ApiOperation("返回参数值")
    @ApiResponses(
            @ApiResponse(code = 200,message = "返回参数值")
    )
    public String swaggerParam(@ApiParam(value = "name",required = false ,defaultValue="",example = "somethingname") String name){
        return name;
    }
}
