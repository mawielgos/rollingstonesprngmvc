package com.rollingstone.recipes.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.rollingstone.recipes.oxm.GetRecipeRequest;
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
public class GetRecipeEndpoint {

	protected static Logger logger = Logger.getLogger(GetRecipeEndpoint.class);

	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	public static final String NAMESPACE_URI = "http://binit.blogspot.com/ws/schema/recipe";

	public static final String REQUEST_LOCAL_NAME = "getRecipeRequest";

	@PayloadRoot(localPart = REQUEST_LOCAL_NAME, namespace = NAMESPACE_URI)
	@ResponsePayload
	public GetRecipeResponse getAllRecipe( @RequestPayload GetRecipeRequest getReipeRequest) {
		try {
			logger.debug("Received subscription request");
			try {
				logger.debug("Delegate to service");
				recipeService.getAllRecipes();
				
			}  catch (Exception e) {
				logger.error("Unable to subscribe");

				// Return response
				GetRecipeResponse response = new GetRecipeResponse();
				response.setCode("FAILURE");
				
				return response;
			}

		} catch (Exception e) {
			logger.error("Problem with subscription request");

			// Return response
			GetRecipeResponse response = new GetRecipeResponse();
			response.setCode("FAILURE");
			
			return response;
		}
		logger.debug("Success in subscribing");
		
		GetRecipeResponse response = new GetRecipeResponse();
		response.setCode("SUCCESS");

		return response;
	}
}
