package com.rollingstone.orderprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.rollingstone.orderprocessing.dao.ICountryDao;
import com.rollingstone.orderprocessing.dao.IStateDao;
import com.rollingstone.orderprocessing.model.Country;
import com.rollingstone.orderprocessing.model.State;

public class CountryServiceImpl implements ICountryService {

	ICountryDao countryDao;
	
	
	public ICountryDao getStateDao() {
		return countryDao;
	}
	

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return null;
	}


	public ICountryDao getCountryDao() {
		return countryDao;
	}

	@Autowired
	@Required
	public void setCountryDao(ICountryDao countryDao) {
		this.countryDao = countryDao;
	}


	@Override
	public Country getCountry(long countryID) {
		// TODO Auto-generated method stub
		return null;
	}

}
