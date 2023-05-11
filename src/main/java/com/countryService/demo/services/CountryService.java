package com.countryService.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryService.demo.beans.Country;
import com.countryService.demo.controllers.AddResponse;
import com.countryService.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	
	@Autowired
	CountryRepository countryRep;

//	static HashMap<Integer, Country> countryIdMap;
//
//	public CountryService() {
//
//		countryIdMap = new HashMap<Integer, Country>();
//		Country IndiaCountry = new Country(1, "India", "Delhi");
//		Country USACountry = new Country(1, "USA", "Washington");
//
//		Country UKCountry = new Country(1, "UK", "London");
//
//		countryIdMap.put(1, IndiaCountry);
//		countryIdMap.put(2, USACountry);
//		countryIdMap.put(3, UKCountry);
//
//	}
//
//	//get all countries
//	public List<Country> getAllCountries() {
//
//		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
//
//		return countries;
//	}
//
//	// get country by id
//	public Country getCountryById(int id) {
//		Country country = countryIdMap.get(id);
//
//		return country;
//	}
//	
//	// get country by name 
//	public Country getCountryByName(String CountryName) {
//		
//		Country country = null;
//		
//		for(int i : countryIdMap.keySet()) {
//			
//			if(countryIdMap.get(i).equals(CountryName)) {
//				country = countryIdMap.get(i);
//			}
//		}
//		
//		return country;
//		
//	}
//	// add country 
//	public Country AddCountry(Country country) {
//		
//		country.setId(maxId());
//		countryIdMap.put(country.getId(), country);
//		return country;
//		
//	}
//	public static int maxId() {
//		
//		int max =0;
//		
//		for(int id : countryIdMap.keySet())
//			
//			if(max<=id) 
//				max = id;
//				
//		return max+1;
//		
//	}
//	
//	//update country 
//	public Country updateCountry(Country country) {
//		
//		if(country.getId()>0) {
//			countryIdMap.put(country.getId(), country);
//		}
//		return country;	
//		
//	}
//	
//	// delete Country 
//	
//	public AddResponse deleteCountry(int id) {
//		
//		countryIdMap.remove(id);
//		AddResponse response = new AddResponse();
//		response.setId(id);
//		response.setMsg("country deleted");
//		
//		return response;
//		
//	}
//	
	public CountryService() {

		

	}

	//get all countries
	public List<Country> getAllCountries() {

		return countryRep.findAll();
	}

	// get country by id
	public Country getCountryById(int id) {
		
		return countryRep.findById(id).get()		;
	}
	
	// get country by name 
	public Country getCountryByName(String CountryName) {
		List<Country> countires = countryRep.findAll();
		Country country = null;
		
		for(Country con : countires)
		{
			if(con.getCountryName().equals(CountryName)) {
				country = con;
			}
		}
		return country;
		
	}
	// add country 
	public Country AddCountry(Country country) {
		country.setId(maxId());
		 countryRep.save(country);
		 return country;
		
	}
	public  int maxId() {
		
		return countryRep.findAll().size()+1;
	}
	
	//update country 
	public Country updateCountry(Country country) {
		 countryRep.save(country);
		 return country;
	
	}
	
	// delete Country 
	
	public AddResponse deleteCountry(int id) {
		
		countryRep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("Country deleted...");
		res.setId(id);
		return res;
	
	}
	
	
}
