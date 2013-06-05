package com.rollingstone.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
@Entity
@Table(name="CATEGORY")
//@SequenceGenerator(sequenceName="SEQ_ADDRESS",name="SEQ_ADDRESS")
public class ProductCategory {

	@Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ADDRESS")
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CATEGORYID")
	long categoryId;
	
	@Column(name="CATEGORYNAME")
	int categoryName;
	
	

		
	public String toString(){
		return "";
	}




	public long getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}




	public int getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(int categoryName) {
		this.categoryName = categoryName;
	}
}
