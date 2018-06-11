package com.mdachu.zuul.mdachuzuul;

import com.mdachu.zuul.mdachuzuul.filter.UrlFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MdachuZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdachuZuulApplication.class, args);
	}


	@Bean
	public UrlFilter filter(){
		return new UrlFilter();
	}
}
