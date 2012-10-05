package com.rollingstone.orderprocessing.model.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.rollingstone.orderprocessing.model.Country;
import com.rollingstone.orderprocessing.service.ICountryService;

public class PhoneTypeEditor extends PropertyEditorSupport {

    private ICountryService countryService;

    @Autowired
    public PhoneTypeEditor(ICountryService countryService) {
        this.countryService = countryService;
    }

    public void setAsText(String text) throws IllegalArgumentException {
        int countryId = Integer.parseInt(text);
        Country country = countryService.getCountry(countryId);
        setValue(country);
    }
}
