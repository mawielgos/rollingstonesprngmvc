package com.rollingstone.orderprocessing.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class Customer {

	long customerId;
	
	String customerName;
	
	Date memberSince;
	
	Address customerAddress;
	
	double balance;
	
	CreditCard defaultCard;
	
	List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	@XmlElement
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public long getCustomerId() {
		return customerId;
	}

	@XmlElement
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	@XmlElement
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	@XmlElement
	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	@XmlElement
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public double getBalance() {
		return balance;
	}

	@XmlElement
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public CreditCard getDefaultCard() {
		return defaultCard;
	}

	@XmlElement
	public void setDefaultCard(CreditCard defaultCard) {
		this.defaultCard = defaultCard;
	}
	
	
	
	
}
