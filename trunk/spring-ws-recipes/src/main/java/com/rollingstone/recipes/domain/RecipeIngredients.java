package com.rollingstone.recipes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ingredients")
@Entity
@Table(name="RECIPE_INGREDIENTS")
public class RecipeIngredients {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INGREDIENT_ID")
	long recipeDetailId;
	
	@Column(name="INGREDIENT_NAME")
	String ingredientName;
	
	@Column(name="UOM")
	String uom;
	
	@Column(name="QUANTITY")
	String quantity;
	
	@ManyToOne
	@JoinColumn(name="RECIPEID", nullable=false, insertable=true, updatable=true)
	Recipe recipe;

	public long getRecipeDetaildId() {
		return recipeDetailId;
	}

	public void setRecipeDetaildId(long recipeDetaildId) {
		this.recipeDetailId = recipeDetaildId;
	}

	public String getName() {
		return ingredientName;
	}

	public void setName(String name) {
		this.ingredientName = name;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}