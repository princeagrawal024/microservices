package com.demo.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //this is optional
public class RatingDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
	}

}
