package com.example.evaluateCredit_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EvaluateCreditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluateCreditServiceApplication.class, args);
	}

}
