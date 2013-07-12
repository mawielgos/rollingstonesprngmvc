//package com.rollingstone.recipes.controller;
//
//import javax.annotation.Resource;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.ws.soap.client.SoapFaultClientException;
//
//import com.rollingstone.recipes.oxm.GetRecipeRequest;
//import com.rollingstone.recipes.oxm.GetRecipeResponse;
//import com.rollingstone.recipes.oxm.RecipePort;
//
///**
// * Handles and retrieves the subscription request
// */
//@Controller
//@RequestMapping("/main")
//public class MainController {
//
//	protected static Logger logger = Logger.getLogger("controller");
//
//	@Resource(name="recipeJaxProxyService")
//	private RecipePort recipeJaxProxyService;
//
//	/**
//	 * Handles the subscription request
//	 */
//	@RequestMapping(value = "/recipe", method = RequestMethod.GET)
//	public String doSubscribe(GetRecipeRequest request) {
//		logger.debug("Received request to subscribe");
//
//		// The "subscriptionAttribute" model has been passed to the controller from the JSP
//		// We use the name "subscriptionAttribute" because the JSP uses that name
//
//		// Delegate to webServiceTemplate for the actual subscription
//		try {
//			GetRecipeResponse response = recipeJaxProxyService.response(request);
//
//			// The message has been sent
//			// But it doesn't mean we're subscribed successfully
//			logger.debug(response.getCode());
//			logger.debug(response.getRecipe());
//
//		} catch (SoapFaultClientException sfce) {
//			logger.error("We sent an invalid message", sfce);
//		} catch (Exception e) {
//			logger.error("Unexpected exception", e);
//		}
//
//		// Show the subscribe page again regardless if successful or not
//		// This will resolve to /WEB-INF/jsp/subscribepage.jsp
//		return "subscribepage";
//	}
//
//}