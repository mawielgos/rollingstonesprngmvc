package com.rollingstone.recipes.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rollingstone.recipes.domain.Recipe;

/**
 * Handles subscription services like adding a new record or unsubscribing.
 * <p>
 * This is a Spring MVC @Service. Spring WS can communicate with this service.
 */
@Service("subscriptionService")
@Transactional
public class RecipeService implements IRecipeService {

	protected static Logger logger = Logger.getLogger(RecipeService.class);

	@Override
	public Recipe getRecipe(long recipeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecipe(long recipeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
	}
}
