package com.rollingstone.recipes.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.domain.RecipeIngredients;

@Repository
public class RecipeHibernateDaoImpl extends AbstractDAO implements IRecipeDao {

	Logger logger = Logger.getLogger(RecipeHibernateDaoImpl.class);

	@Override
	public Recipe getRecipe(String recipeName) {
		return null;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Recipe.class);
        List<Recipe> recipesList = c.list();
        session.close();
        
        return recipesList;
//		ResponseObject<Recipe> resObj = new ResponseObject<Recipe>();
//		resObj.setTotalItems(customerList.size());
//		resObj.setListOfModels(customerList);
//        return resObj ;
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	List<RecipeIngredients> ingredients = (List<RecipeIngredients>) recipe.getIngredients();

        	for (Iterator<RecipeIngredients> ingredientItr = ingredients.iterator(); ingredientItr.hasNext(); ){
        		RecipeIngredients ingredient = ingredientItr.next();
        		ingredient.setRecipe(recipe);
        	}
        	
        	session.update(recipe);
        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        }finally{
            session.close();
        }
   	
        return recipe;
	}

	@Override
	public boolean deleteRecipe(int recipeId) {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try{
        	Recipe recipe = (Recipe) session.get(Recipe.class, recipeId);
    		session.delete(recipe);
    		session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        }finally{
            session.close();
        }

        return true;
		
	}

	@Override
	public Recipe createRecipe(Recipe recipe) {
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        try {
        	List<RecipeIngredients> ingredients = (List<RecipeIngredients>) recipe.getIngredients();

        	for (Iterator<RecipeIngredients> ingredientItr = ingredients.iterator(); ingredientItr.hasNext(); ){
        		RecipeIngredients ingredient = ingredientItr.next();
        		ingredient.setRecipe(recipe);
        	}
        	
        	session.save(recipe);
        	session.getTransaction().commit();
        }catch(Exception e){
        	session.getTransaction().rollback();
        	logger.error(e.getMessage());
        
        }finally{
            session.close();
        }
    	return recipe;
	}
}
