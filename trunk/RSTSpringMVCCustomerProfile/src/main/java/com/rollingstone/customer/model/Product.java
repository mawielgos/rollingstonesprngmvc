package com.rollingstone.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
@Entity
@Table(name="PRODUCT")
public class Product {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PRODUCT")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCTID")
	int productId;
	
	
	
	@Column(name="PROD_SHORT_NAME")
	String productShortName;
	
	@Column(name="PRODUCTNAME")
	String productName;
	
	@Column(name="PRODUCT_PRICE")
	float productPrice;

	@Column(name="PRODUCT_IMAGE_PATH")
	String productImagePath;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	
	
}
