package com.rollingstone.orderprocessing.dao;

import java.util.List;

import com.rollingstone.orderprocessing.model.Country;

public interface ICountryDao {

	List<Country> getAllCountries();
	
}
