package com.rollingstone.orderprocessing.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "creditcard")
public class CreditCard {

	String cardNumber;
	
	String securityCode;
	
	Date expDate;
	
	String cardType;

	public String getCardNumber() {
		return cardNumber;
	}

	@XmlElement
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	@XmlElement
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Date getExpDate() {
		return expDate;
	}

	@XmlElement
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCardType() {
		return cardType;
	}

	@XmlElement
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
}
