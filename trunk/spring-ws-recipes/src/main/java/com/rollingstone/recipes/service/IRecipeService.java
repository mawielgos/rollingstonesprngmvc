package com.rollingstone.recipes.service;

import java.util.List;

import com.rollingstone.recipes.domain.Recipe;

public interface IRecipeService {

Recipe getRecipe(long recipeId);
	
	List<Recipe> getAllRecipes();
	
	void saveRecipe(Recipe recipe);
	
	void deleteRecipe(long recipeId);
	
	void createRecipe(Recipe recipe);
}
