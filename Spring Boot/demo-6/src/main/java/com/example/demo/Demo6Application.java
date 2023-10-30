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
* This application uses Java SE 17.02 with Spring Boot
*/
@SpringBootApplication
public class Demo6Application {

	public static void main(String[] args) {
		

		//SpringApplication.run(Demo4Application.class, args);
		ConfigurableApplicationContext app = SpringApplication.run(Demo6Application.class, args);
		Arrays.stream(app.getBeanDefinitionNames()).forEach(System.out::println);
		
		
	}

}
