package com.rollingstone.orderprocessing.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

	long productId;
	
	String productName;
	
	public long getProductId() {
		return productId;
	}

	@XmlElement
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	@XmlElement
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	@XmlElement
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public byte[] getImage() {
		return image;
	}

	@XmlElement
	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getProductType() {
		return productType;
	}

	@XmlElement
	public void setProductType(String productType) {
		this.productType = productType;
	}

	String productDescription;
	
	byte[] image;
	
	String productType;
	
	
}
