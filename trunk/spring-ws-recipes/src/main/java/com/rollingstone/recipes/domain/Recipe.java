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
@Table(name="RECIPE")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RECIPEID")
	long recipeId;
	
	@Column(name="RECIPE_NAME")
	String recipeName;
	
	@Column(name="DESCRIPTION")
	String recipeDescripton;
	
	@Column(name="CREATED_ON")
	Date createdOn;
	
	@Column(name="CREATED_BY")
	String createdBy;
	
	@Column(name="RECIPETYPE")
	String recipeType;
	
	@Column(name="VISITOR_COUNT")
	long visitorCount;
	
	@Column(name="PROCESS")
	String process;

	@OneToMany(mappedBy="recipe", fetch=FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	List<RecipeIngredients> ingredients;
	
	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeDescripton() {
		return recipeDescripton;
	}

	public void setRecipeDescripton(String recipeDescripton) {
		this.recipeDescripton = recipeDescripton;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public List<RecipeIngredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredients> ingredients) {
		this.ingredients = ingredients;
	}

	public void recipe(){
		
	}

	public long getrecipeId() {
		return recipeId;
	}

	public void setrecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	public String getrecipeName() {
		return recipeName;
	}

	public void setrecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getrecipeDescripton() {
		return recipeDescripton;
	}

	public void setrecipeDescripton(String recipeDescripton) {
		this.recipeDescripton = recipeDescripton;
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

	public String getrecipeType() {
		return recipeType;
	}

	public void setrecipeType(String recipeType) {
		this.recipeType = recipeType;
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
