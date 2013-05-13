package com.rollingstone.customer.model;

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

@XmlRootElement(name = "address")
@Entity
@Table(name="ADDRESS")
@SequenceGenerator(sequenceName="SEQ_ADDRESS",name="SEQ_ADDRESS")
public class Address {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ADDRESS")
    @Column(name="ADDRESSID")
	long addressId;
	
	@Column(name="HOUSENUMBER")
	int houseNumber;
	
	@Column(name="STREET")
	String street;
	
	@Column(name="CITY")
	String city;
	
	@Column(name="STATE")
	String state;
	
	@Column(name="COUNTRY")
	String country;	

	@ManyToOne
	@JoinColumn(name="CUSTOMERID", nullable=false, insertable=true, updatable=true)
	Customer customer;
	
	
	
	/**
	 * @return the addressId
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the customer
	 */
	public int getCustomer() {
		return this.customer.getCustomerId();
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	@XmlElement
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	@XmlElement
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString(){
		return this.getHouseNumber() + " " +this.getStreet() + " "+ this.getCity() + " " + this.getState() + " " + this.getCountry();		
	}
}
