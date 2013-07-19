package com.rollingstone.recipes.dao;

import java.util.List;

import com.rollingstone.recipes.domain.Recipe;

public interface IRecipeDao {

	List<Recipe> searchRecipe(String recipeName, String recipeType);
	
	List<Recipe> getAllRecipes();
	
	Recipe saveRecipe(Recipe recipe);
	
	boolean deleteRecipe(int recipeId) throws Exception;
	
	Recipe createRecipe(Recipe recipe);
}
