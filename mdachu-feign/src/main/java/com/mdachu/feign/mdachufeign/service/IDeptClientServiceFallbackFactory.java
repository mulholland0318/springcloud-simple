package com.mdachu.feign.mdachufeign.service;

import feign.hystrix.FallbackFactory;

import java.util.List;

public class IDeptClientServiceFallbackFactory implements FallbackFactory<IDeptClientService> {
    @Override
    public IDeptClientService create(Throwable throwable) {
        return new IDeptClientService(){

            @Override
            public String get(long id) {
                return "the id is :" + id;
            }

            @Override
            public List<String> list() {
                return null;
            }

            @Override
            public boolean add(String param) {
                return false;
            }
        };
    }

}
