package com.example.register_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.example.register_service.Entity")
public class RegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterServiceApplication.class, args);
	}

}
