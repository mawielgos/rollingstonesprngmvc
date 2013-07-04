package com.rollingstone.recipes.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.rollingstone.recipes.domain.Recipe;
import com.rollingstone.recipes.oxm.EditRecipeRequest;
import com.rollingstone.recipes.oxm.GetRecipeResponse;
import com.rollingstone.recipes.service.RecipeService;


/**
 * Handles recipe requests. 
 * <p>
 *<pre>
 * @Endpoint: similar to Spring MVC's @Controller. 
 * @PayloadRoot: similar to Spring MVC's @RequestMapping</pre>
 */
@Endpoint
public class EditRecipeEndpoint {

	protected static Logger logger = Logger.getLogger(EditRecipeEndpoint.class);

	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	public static final String NAMESPACE_URI = "http://binit.blogspot.com/ws/schema/recipe";

	public static final String REQUEST_LOCAL_NAME = "editRecipeRequest";

	@PayloadRoot(localPart = REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
	@ResponsePayload
	public GetRecipeResponse getAllRecipe( @RequestPayload EditRecipeRequest editReipeRequest) {
		try {
			try {
				String editType = editReipeRequest.getEditType();
				Recipe recipe = editReipeRequest.getRecipe();
				if (editType.equals("ADD")){
					recipeService.saveRecipe(recipe);				
				}else{
					recipeService.saveRecipe(recipe);
				}
			}  catch (Exception e) {
				logger.error("Unable to save recipe");

				GetRecipeResponse response = new GetRecipeResponse();
				response.setCode("FAILURE");
				
				return response;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			GetRecipeResponse response = new GetRecipeResponse();
			response.setCode("FAILURE");
			return response;
		}
		
		GetRecipeResponse response = new GetRecipeResponse();
		response.setCode("SUCCESS");

		return response;
	}
}
