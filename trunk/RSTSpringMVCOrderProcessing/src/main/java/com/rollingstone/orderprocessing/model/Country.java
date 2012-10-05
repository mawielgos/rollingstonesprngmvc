package com.rollingstone.orderprocessing.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public class Country {
	
	long countryId;
	
	String countryName;
	
	String countryShortName;
	
	long countryISDCode;

	public long getCountryId() {
		return countryId;
	}

	@XmlElement
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	@XmlElement
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryShortName() {
		return countryShortName;
	}

	@XmlElement
	public void setCountryShortName(String countryShortName) {
		this.countryShortName = countryShortName;
	}

	public long getCountryISDCode() {
		return countryISDCode;
	}

	@XmlElement
	public void setCountryISDCode(long countryISDCode) {
		this.countryISDCode = countryISDCode;
	}
	
	

	
}
