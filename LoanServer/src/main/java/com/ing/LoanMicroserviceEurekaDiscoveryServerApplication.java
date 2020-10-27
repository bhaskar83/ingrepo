package com.ing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoanMicroserviceEurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanMicroserviceEurekaDiscoveryServerApplication.class, args);
	}

}






