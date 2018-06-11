package com.mdachu.servera.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}


	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/zuul/test")
	public String test(){
		client.getServices().forEach(s -> System.out.println(s));
		return client.description();
	}

	@RequestMapping("/zuul/helloworld")
	public String helloWorld(){
		return "helloworld";
	}

}
