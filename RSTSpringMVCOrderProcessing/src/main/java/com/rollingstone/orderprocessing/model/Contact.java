package com.rollingstone.orderprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
@Entity
@Table(name="CONTACT")
@SequenceGenerator(sequenceName="SEQ_CONTACT",name="SEQ_CONTACT")
public class Contact {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTACT")
    @Column(name="CONTACTID")
	long contactId;
	
	@Column(name="PHONENUMBER")
	String phoneNumber;
	
	@Column(name="PHONETYPE")
	String phoneType;
	
	@Column(name="CONTACTTYPE")
	String contactType;
	
	@Column(name="EMAILID")
	String emailId;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMERID", insertable=true, updatable=true)
	Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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
