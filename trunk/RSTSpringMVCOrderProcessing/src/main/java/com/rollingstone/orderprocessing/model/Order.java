package com.rollingstone.orderprocessing.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order {
	
	long orderNumber;
	
	Date orderDate;
	
	double orderAmount;
	
	Customer customer;
	
	String status;
	
	List<OrderItem> items;

	public long getOrderNumber() {
		return orderNumber;
	}

	@XmlElement
	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	@XmlElement
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	@XmlElement
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	@XmlElement
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@XmlElement
	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	@XmlElement
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItem(OrderItem item){
		items.add(item);
	}
	
	public void removeItem(OrderItem item){
		items.remove((OrderItem) item);
	}
	

}
