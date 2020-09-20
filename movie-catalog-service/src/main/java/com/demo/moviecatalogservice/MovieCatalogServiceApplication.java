package com.demo.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //this is optional
public class MovieCatalogServiceApplication {
	
	@Bean
	@LoadBalanced //remove this to use hardcoded url //this will work with Ureka url
	public RestTemplate getRestTemplate() {
		//this is the right approach as this will create only one approach
		//Synchronous Programming
		//RestTemplate is thread Safe
		return new RestTemplate();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
