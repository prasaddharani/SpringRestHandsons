package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;


@Component
public class CountryDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);
	
	static ArrayList<Country> countryList;
	public CountryDao() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		countryList = (ArrayList<Country>) context.getBean("countryList");
		
	}
	
	public List<Country> getAllCountries(){
		return countryList;
	}
	
	public Country updateCountry(Country country) throws CountryNotFoundException
	{
		LOGGER.info("Inside updateCountry() method");
		for(Country c:countryList)
		{
			if(c.getCode().equalsIgnoreCase(country.getCode()))
			{
				c.setName(country.getName());
				
				
				return c;
			}
		}
		throw new CountryNotFoundException();
	}
	
	
	
	
public void deleteCountry(String code) throws CountryNotFoundException {
		Country c=null;
		for(Country country:countryList)
		{
			if(country.getCode().equalsIgnoreCase(code))
			{
				c=country;
				countryList.remove(c);
				break;
			}
		}
		if(c==null)
		{
			throw new CountryNotFoundException();
		}
	}
	


}
