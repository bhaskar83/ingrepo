package com.ing.login.loan;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginMIcroserviceEurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(LoginMIcroserviceEurekaClient1Application.class, args);
	}

}
