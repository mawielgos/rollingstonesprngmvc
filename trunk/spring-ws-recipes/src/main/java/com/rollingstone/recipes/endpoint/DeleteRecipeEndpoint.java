package com.rollingstone.recipes.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.rollingstone.recipes.oxm.DeleteRecipeRequest;
import com.rollingstone.recipes.oxm.DeleteRecipeResponse;
import com.rollingstone.recipes.service.RecipeService;


/**
 * Handles recipe requests. 
 * <p>
 *<pre>
 * @Endpoint: similar to Spring MVC's @Controller. 
 * @PayloadRoot: similar to Spring MVC's @RequestMapping</pre>
 */
@Endpoint
public class DeleteRecipeEndpoint {

	protected static Logger logger = Logger.getLogger(DeleteRecipeEndpoint.class);

	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	public static final String NAMESPACE_URI = "http://binit.blogspot.com/ws/schema/recipe";

	public static final String REQUEST_LOCAL_NAME = "getRecipeRequest";

	@PayloadRoot(localPart = REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
	@ResponsePayload
	public DeleteRecipeResponse deleteAllRecipe( @RequestPayload DeleteRecipeRequest deleteReipeRequest) {
		try {
			logger.debug("Received delete request");
			try {
				int recipeId = deleteReipeRequest.getRecipeId();
				recipeService.deleteRecipe(recipeId);
				
			}  catch (Exception e) {
				logger.error("Unable to delete");

				DeleteRecipeResponse response = new DeleteRecipeResponse();
				response.setCode("FAILURE");
				
				return response;
			}

		} catch (Exception e) {
			logger.error("Problem with delete request");

			// Return response
			DeleteRecipeResponse response = new DeleteRecipeResponse();
			response.setCode("FAILURE");
			
			return response;
		}
		logger.debug("Success in deletion");
		
		DeleteRecipeResponse response = new DeleteRecipeResponse();
		response.setCode("SUCCESS");

		return response;
	}
}
