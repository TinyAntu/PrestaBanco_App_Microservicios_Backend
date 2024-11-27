package com.example.followRequest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FollowRequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowRequestServiceApplication.class, args);
	}

}
