package com.rollingstone.orderprocessing.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@Entity
@Table(name="CUSTOMER")
@SequenceGenerator(sequenceName="SEQ_CUSTOMER",name="SEQ_CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CUSTOMER")
	@Column(name="CUSTOMERID")
	long customerId;

	@Column(name="CUSTOMERNAME")
	String customerName;
	
	@Column(name="MEMBERSINCE")
	Date memberSince;
	
	@Column(name="BALANCE")
	double balance;	
	
	@OneToOne
    @JoinColumn(name="ADDRESSID", insertable=true, updatable=true, nullable=false)
	Address customerAddress;
	
	@OneToOne
    @JoinColumn(name="CREDITCARDID", insertable=true, updatable=true, nullable=false)
	CreditCard defaultCard;

//	@OneToOne
//    @JoinColumn(name="CONTACTID", insertable=true, updatable=true, nullable=false)
//	Contact contacts;
	
	@OneToMany(mappedBy="customer",cascade={CascadeType.ALL})
	List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	@XmlElement
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

//	public Contact getContacts() {
//		return contacts;
//	}
//
//	public void setContacts(Contact contacts) {
//		this.contacts = contacts;
//	}

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
