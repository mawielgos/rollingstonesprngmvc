package com.rollingstone.orderprocessing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "creditcard")
@Entity
@Table(name="CREDITCARD")
@SequenceGenerator(sequenceName="SEQ_CREDITCARD",name="SEQ_CREDITCARD")
public class CreditCard {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CREDITCARD")
    @Column(name="CREDITCARDID")
    long creditCardId;
    
    @Column(name="CARDNUMBER")
	String cardNumber;
	
    @Column(name="SECURITYCODE")
	String securityCode;
	
	@Column(name="EXPDATE")
	Date expDate;
	
    @Column(name="CARDTYPE")
	String cardType;

	public String getCardNumber() {
		return cardNumber;
	}

    public long getCreditCardId() {
		return creditCardId;
	}

    @XmlElement
	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
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
