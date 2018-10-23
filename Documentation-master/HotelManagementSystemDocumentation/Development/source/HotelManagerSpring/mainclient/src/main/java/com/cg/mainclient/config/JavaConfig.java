package com.cg.mainclient.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JavaConfig {

	//Rest Template...
	@Bean
	public RestTemplate getTemplate(){
		return new RestTemplate();
	}
}
