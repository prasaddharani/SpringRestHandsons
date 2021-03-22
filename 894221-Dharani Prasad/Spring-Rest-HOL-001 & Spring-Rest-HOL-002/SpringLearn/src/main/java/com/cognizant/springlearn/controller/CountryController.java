package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
@RestController
public class CountryController {
	@Autowired
	private Country country;
	@Autowired
	private List<Country> listCountries;
	
	@RequestMapping(value="/country")
	public Country getCountryIndia() {
		return country;
		
	}
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		return listCountries;
		
	}
	
	@GetMapping("/country/{code}")
	  public Country getPersonWithId(@PathVariable String code){
		
			return new Country("IN","India");
		
		
	    
	  } 

}
