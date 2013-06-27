package com.rollingstone.recipes.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.TriggersRemove;
import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.domain.RecipeIngredients;
import com.rollingstone.recipes.domain.ResponseObject;

@Repository
public class RecipeHibernateDaoImpl extends AbstractDAO implements IRecipeDao {

	Logger logger = Logger.getLogger(RecipeHibernateDaoImpl.class);



	@Override
	public Recipe getRecipe(long recipeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseObject<Recipe> getAllRecipes() {
		List<Recipe> recipesList = new ArrayList<Recipe>();
	    
		SessionFactory sf = hbUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria c = session.createCriteria(Recipe.class);
        List<Recipe> customerList = c.list();
        session.close();
        
		ResponseObject<Recipe> resObj = new ResponseObject<Recipe>();
		resObj.setTotalItems(customerList.size());
		resObj.setListOfModels(customerList);
        return resObj ;
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
        		ingredient.setRecepe(recipe);
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
	public boolean deleteRecipe(long recipeId) {
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
        		ingredient.setRecepe(recipe);
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
