package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;



/**
*@author Henry Weber 
*@version 1.0
* The application is a library database with Book objects
* This application uses Java SE 17.02 with Spring Boot 3.1.5s
*/
//@SpringBootApplication is a combination of these three annotations - @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication

public class Demo5Application {

	public static void main(String[] args) {
				
		//To show the Beans inside the Application Context
		ConfigurableApplicationContext app = SpringApplication.run(Demo5Application.class, args);
		Arrays.stream(app.getBeanDefinitionNames()).forEach(System.out::println);
		
		
	}

}
