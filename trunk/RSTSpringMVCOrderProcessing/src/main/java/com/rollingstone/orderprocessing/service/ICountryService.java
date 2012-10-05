package com.rollingstone.orderprocessing.service;

import java.util.List;

import com.rollingstone.orderprocessing.model.Country;

public interface ICountryService {

	List <Country> getAllCountries();
	
	Country getCountry(long countryID);
}
