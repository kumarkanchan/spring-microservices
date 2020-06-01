package com.springboot.basic.springbootsteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootStepsApplication {

	public static void main(String[] args) {
		 ApplicationContext applicationContext =
		                    SpringApplication.run(SpringBootStepsApplication.class, args);
		 
		 
		 for(String name:applicationContext.getBeanDefinitionNames()) {
			 System.out.println(name);
		 }
	}

}
