package com.cybage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages= "com.cybage")
@EnableJpaRepositories(basePackages = "com.cybage.dao")
@EntityScan("com.cybage.model")
public class Crudassignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(Crudassignment1Application.class, args);
	}
		
		@Bean

		 
		public RestTemplate restTemplate() 
		{
		 return new RestTemplate();
		}
	

}
