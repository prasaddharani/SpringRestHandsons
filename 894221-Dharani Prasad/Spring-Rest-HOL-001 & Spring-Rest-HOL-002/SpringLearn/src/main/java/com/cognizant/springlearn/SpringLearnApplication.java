package com.cognizant.springlearn;

import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource({"classpath:country.xml"})
public class SpringLearnApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountry();
		displayCountries();			
		
	}
	public static void displayCountry() {
		Logger logger = LoggerFactory.getLogger(Country.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country");
		Country anotherCountry = context.getBean("country", Country.class);
		System.out.println("Handson1");
		logger.debug("Country : {}", country.toString());
		System.out.println("Handson2");
		logger.debug("Country : {}",anotherCountry.toString());
		
	}
	public static void displayCountries(){
		Logger logger = LoggerFactory.getLogger(Country.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		@SuppressWarnings("unchecked")
		List<Country> lists=(List<Country>) context.getBean("countryList");
		System.out.println("Handson3");
		for(Country c:lists) {
			logger.debug("Country : {}",c.toString());
			
		}
	}
	
	

}
