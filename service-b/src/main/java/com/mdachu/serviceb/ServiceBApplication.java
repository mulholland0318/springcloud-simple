package com.mdachu.serviceb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}


	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/zuul/test")
	public String test(){
		client.getServices().forEach(p -> System.out.println(p));
		return client.description();
	}

}
