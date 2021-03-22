package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	@Autowired
	private CountryDao countryDao;
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	@SuppressWarnings("unchecked")
	ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
	
	
	public List<Country> getAllCountries(){
		
		return countryDao.getAllCountries();
	}
		
	public String getCountry(String code) throws CountryNotFoundException  {
		String c=null;
		for(Country var:countryList) {
			if(code.equalsIgnoreCase(var.getCode())) {
				c=var.toString();
				
			}
			
		}
		
		return c;
	}
	
	public Country addCountry(Country country) {
		
		if(countryList.add(country))
		
			return country;
		
			
		
		return null;
		
	}

	public void deleteCountry(String code) throws CountryNotFoundException {
		countryDao.deleteCountry(code);
	}

	public Country updateCountry(Country country) {
		
		return countryDao.updateCountry(country);
	}
		
	
}
