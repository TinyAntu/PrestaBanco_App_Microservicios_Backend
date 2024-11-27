package com.example.requestCredit_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RequestCreditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestCreditServiceApplication.class, args);
	}

}
