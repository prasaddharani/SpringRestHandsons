package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.exception.CountryNotFoundException;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!!";
	}
	@RequestMapping(value="/country",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in");
		return country;
		
	}
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		
		return countryService.getAllCountries();
		
	}
	
	@GetMapping(value="/countries/{code}")
	  public String getCountryWithCode (@PathVariable String code) {
			
		
			String s=countryService.getCountry(code);
			if(s== null) {
		         throw new CountryNotFoundException();
		    }
			
			return s;
		
	  } 
	@PostMapping(value="/countries",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Country addCountry(@RequestBody Country country) {
		LOGGER.debug("Start");
		
		LOGGER.debug("Added {}", country);
		
		LOGGER.info("End");
		countryService.addCountry(country);
		return country;
		
		
	}
	
	@RequestMapping(value="/countries/{code}",method=RequestMethod.DELETE,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void deleteCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		LOGGER.debug("Delete method");
		countryService.deleteCountry(code);
	}
	
	@RequestMapping(value="/countries",method = RequestMethod.PUT)
	public Country updateCountry(@RequestBody @Valid Country country) throws CountryNotFoundException {
		
		return countryService.updateCountry(country);
	}
}
