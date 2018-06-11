package com.mdachu.feign.mdachufeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "hystrix-client", fallbackFactory = IDeptClientServiceFallbackFactory.class)
public interface IDeptClientService {

    @RequestMapping(method = RequestMethod.GET, value = "/dept/get/{id}")
    public String get(@PathVariable("id") long id);
    @RequestMapping(method = RequestMethod.GET, value = "/dept/list")
    public List<String> list();
    @RequestMapping(method = RequestMethod.POST, value = "/dept/add")
    public boolean add(String param);
}
