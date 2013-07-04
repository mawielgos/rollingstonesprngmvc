package com.rollingstone.recipes.dao;

import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.domain.ResponseObject;

public interface IRecipeDao {

	Recipe getRecipe(long recipeId);
	
	ResponseObject<Recipe> getAllRecipes();
	
	Recipe saveRecipe(Recipe recipe);
	
	boolean deleteRecipe(long recipeId);
	
	Recipe createRecipe(Recipe recipe);
}
