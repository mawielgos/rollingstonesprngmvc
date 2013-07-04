package com.rollingstone.recipes.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rollingstone.recipes.domain.Recipe;

@Service("recipeService")
@Transactional
public class RecipeService implements IRecipeService {

	protected static Logger logger = Logger.getLogger(RecipeService.class);

	@Override
	public List<Recipe> getRecipe(String recipeName) {
		logger.debug("Calling .... getRecipe("+recipeName+")");
		return null;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		logger.debug("Calling .... getAllRecipes()");
		return null;
	}

	@Override
	public void saveRecipe(Recipe recipe) {
	}

	@Override
	public void deleteRecipe(int recipeId) {
	}

	@Override
	public void createRecipe(Recipe recipe) {
	}
}
