package com.mdachueuraka.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * 解决eureka 开启安全认证 无法链接注册中心，关闭csrf
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();//关闭csrf
        super.configure(http);
    }
}
