package com.rollingstone.orderprocessing.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
public class Contact {

	String phoneNumber;
	
	String phoneType;
	
	String contactType;
	
	String emailId;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@XmlElement
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	@XmlElement
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getContactType() {
		return contactType;
	}

	@XmlElement
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getEmailId() {
		return emailId;
	}

	@XmlElement
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
