package com.rollingstone.recipes.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@XmlRootElement(name = "recipe")
@Entity
@Table(name="RST_RECIPE")
public class Recipe {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CUSTOMER")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECIPEID")
	long recipyId;
	
	@Column(name="NAME")
	String recipyName;
	
	@Column(name="DESCRIPTION")
	String recipyDescripton;
	
	@Column(name="CREATED_ON")
	Date createdOn;
	
	@Column(name="CREATED_BY")
	String createdBy;
	
	@Column(name="TYPE")
	String recipyType;
	
	@Column(name="VISITOR_COUNT")
	long visitorCount;
	
	@Column(name="PROCESS")
	String process;

	@OneToMany(mappedBy="recipe", fetch=FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	List<RecipeIngredients> ingredients;
	
	public List<RecipeIngredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredients> ingredients) {
		this.ingredients = ingredients;
	}

	public void Recipy(){
		
	}

	public long getRecipyId() {
		return recipyId;
	}

	public void setRecipyId(long recipyId) {
		this.recipyId = recipyId;
	}

	public String getRecipyName() {
		return recipyName;
	}

	public void setRecipyName(String recipyName) {
		this.recipyName = recipyName;
	}

	public String getRecipyDescripton() {
		return recipyDescripton;
	}

	public void setRecipyDescripton(String recipyDescripton) {
		this.recipyDescripton = recipyDescripton;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRecipyType() {
		return recipyType;
	}

	public void setRecipyType(String recipyType) {
		this.recipyType = recipyType;
	}

	public long getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(long visitorCount) {
		this.visitorCount = visitorCount;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}
	
	
}
