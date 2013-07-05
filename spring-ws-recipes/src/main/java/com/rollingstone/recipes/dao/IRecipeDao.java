package com.rollingstone.recipes.dao;

import java.util.List;

import com.rollingstone.recipes.domain.Recipe;

public interface IRecipeDao {

	Recipe getRecipe(String recipeName);
	
	List<Recipe> getAllRecipes();
	
	Recipe saveRecipe(Recipe recipe);
	
	boolean deleteRecipe(int recipeId);
	
	Recipe createRecipe(Recipe recipe);
}
