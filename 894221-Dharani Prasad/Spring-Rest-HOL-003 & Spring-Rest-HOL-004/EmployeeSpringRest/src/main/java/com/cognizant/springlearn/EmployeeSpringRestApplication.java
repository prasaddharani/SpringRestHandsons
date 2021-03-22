package com.cognizant.springlearn;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
@SpringBootApplication(scanBasePackages = "com.cognizant.springlearn")
public class EmployeeSpringRestApplication {
	
	static Logger logger = LoggerFactory.getLogger(EmployeeSpringRestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringRestApplication.class, args);
				
	}
	

}
