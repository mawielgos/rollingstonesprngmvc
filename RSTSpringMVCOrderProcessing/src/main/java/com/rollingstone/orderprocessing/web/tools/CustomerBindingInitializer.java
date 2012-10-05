package com.rollingstone.orderprocessing.web.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.rollingstone.orderprocessing.model.Country;
import com.rollingstone.orderprocessing.model.State;
import com.rollingstone.orderprocessing.model.editors.CountryEditor;
import com.rollingstone.orderprocessing.model.editors.StateEditor;
import com.rollingstone.orderprocessing.service.ICountryService;
import com.rollingstone.orderprocessing.service.ICustomerService;
import com.rollingstone.orderprocessing.service.IStateService;

public class CustomerBindingInitializer implements WebBindingInitializer {

    private ICustomerService customerService;
    private IStateService stateService;
    private ICountryService countryService;


    public ICustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public IStateService getStateService() {
		return stateService;
	}

	@Autowired
	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}

	public ICountryService getCountryService() {
		return countryService;
	}

	@Autowired
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}

	@Autowired
    public CustomerBindingInitializer(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
        binder.registerCustomEditor(State.class, new StateEditor(
        		stateService));
        binder.registerCustomEditor(Country.class, new CountryEditor(
        		countryService));
        
        //TODO Add Phone Type
        
        //TODO Add Card Type
    }
}
