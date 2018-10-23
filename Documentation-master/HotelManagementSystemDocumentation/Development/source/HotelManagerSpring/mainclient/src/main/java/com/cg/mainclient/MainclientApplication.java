package com.cg.mainclient;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MainclientApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(MainclientApplication.class, args);
	}

	
}
