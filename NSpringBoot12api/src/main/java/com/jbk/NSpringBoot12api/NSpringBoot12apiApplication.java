package com.jbk.NSpringBoot12api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
    
@CrossOrigin
@SpringBootApplication
@ComponentScan("com.jbk")
public class NSpringBoot12apiApplication {
	               	
	public static void main(String[] args) {
		SpringApplication.run(NSpringBoot12apiApplication.class, args);
		System.out.println("Executed successfull................");
	}
	        
             
}
 