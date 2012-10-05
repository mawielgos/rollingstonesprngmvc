package com.rollingstone.orderprocessing.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orderitem")
public class OrderItem {

	Product product;
	
	public Product getProduct() {
		return product;
	}

	@XmlElement
	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	@XmlElement
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	@XmlElement
	public void setTotal(double total) {
		this.total = total;
	}

	long quantity;
	
	double price;
	
	double total;
}
