package com.rollingstone.recipes.oxm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "RecipePort", targetNamespace = "http://binit.blogspot.com/ws/schema/recipe")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ ObjectFactory.class })
public interface RecipePort {
	@WebMethod
	@WebResult(name = "getRecipeResponse", targetNamespace = "http://binit.blogspot.com/ws/schema/recipe", partName = "getRecipeResponse")
	public GetRecipeResponse response(
			@WebParam(name = "getRecipeRequest", 
			targetNamespace = "http://binit.blogspot.com/ws/schema/recipe", 
			partName = "getRecipeRequest") GetRecipeRequest getRecipeRequest);
}
