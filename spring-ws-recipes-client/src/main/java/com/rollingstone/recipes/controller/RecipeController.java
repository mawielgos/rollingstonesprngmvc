package com.rollingstone.recipes.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.rollingstone.recipes.oxm.DeleteRecipeRequest;
import com.rollingstone.recipes.oxm.DeleteRecipeResponse;
import com.rollingstone.recipes.oxm.EditRecipeRequest;
import com.rollingstone.recipes.oxm.EditRecipeResponse;
import com.rollingstone.recipes.oxm.GetRecipeRequest;
import com.rollingstone.recipes.oxm.GetRecipeResponse;
import com.rollingstone.recipes.oxm.Recipe;
import com.rollingstone.recipes.oxm.RecipePort;

/**
 * Handles and retrieves the subscription request
 */
@Controller
public class RecipeController {

	protected static Logger logger = Logger.getLogger(RecipeController.class);

	@Resource(name="recipeJaxProxyService")
	private RecipePort recipeJaxProxyService;

	/**
	 * Handles the get recipe request
	 */
	@RequestMapping(value = "/getRecipe", method = RequestMethod.GET)
	@ResponseBody
	public String getRecipe(GetRecipeRequest request) {
		try {
			GetRecipeResponse response = recipeJaxProxyService.getRecipe(request);

			logger.debug(response.getCode());
			logger.debug(response.getRecipe());

		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return "Recipe found";
	}
	
	/**
	 * Handles the edit recipe request
	 */
	@RequestMapping(value = "/editRecipe", method = RequestMethod.GET)
	@ResponseBody
	public String editRecipe(EditRecipeRequest request) {
		Recipe rcp = new Recipe();
		request.setEditType("edit");
		request.setRecipe(rcp);
		try {
			EditRecipeResponse response = recipeJaxProxyService.editRecipe(request);

			logger.debug(response.getCode());
		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return "Recipe Edited";
	}

	/**
	 * Handles the delete recipe request
	 */
	@RequestMapping(value = "/deleteRecipe", method = RequestMethod.GET)
	@ResponseBody
	public String deleteRecipe(DeleteRecipeRequest request) {
		request.setRecipeId(1);
		try {
			DeleteRecipeResponse response = recipeJaxProxyService.deleteRecipe(request);

			logger.debug(response.getCode());
		} catch (SoapFaultClientException sfce) {
			logger.error("We sent an invalid message", sfce);
		} catch (Exception e) {
			logger.error("Unexpected exception", e);
		}

		return "Recipe deleted";
	}

}