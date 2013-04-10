package com.rollingstone.orderprocessing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/* Created for sample test ... not used anywhere now */
@XmlRootElement(name = "customer")
@Entity
@Table(name="CUSTOMER")
public class CustomerSimple {

	@Id
	@Column(name="CUSTOMERID")
	long customerId;
	
	@Column(name="CUSTOMERNAME")
	String customerName;
	
//	@Column(name="MEMBERSINCE")
	Date memberSince;
	
	@Column(name="BALANCE")
	float balance;
	
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

	public float getBalance() {
		return balance;
	}

	@XmlElement
	public void setBalance(float balance) {
		this.balance = balance;
	}
}
