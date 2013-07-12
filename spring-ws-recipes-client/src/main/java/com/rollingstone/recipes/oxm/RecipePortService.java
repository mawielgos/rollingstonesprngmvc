package com.rollingstone.recipes.oxm;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "RecipePortService", targetNamespace = "http://binit.blogspot.com/ws/schema/recipe", wsdlLocation = "file:/recipe.wsdl")
public class RecipePortService
    extends Service
{

    private final static URL RECIPEPORTSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("file:recipe.wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RECIPEPORTSERVICE_WSDL_LOCATION = url;
    }

    public RecipePortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RecipePortService() {
        super(RECIPEPORTSERVICE_WSDL_LOCATION, new QName("http://binit.blogspot.com/ws/schema/recipe", "RecipePortService"));
    }

    /**
     * 
     * @return
     *     returns RecipePort
     */
    @WebEndpoint(name = "RecipePortSoap11")
    public RecipePort getRecipePortSoap11() {
        return (RecipePort)super.getPort(new QName("http://binit.blogspot.com/ws/schema/recipe", "RecipePortSoap11"), RecipePort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SubscriptionPort
     */
    @WebEndpoint(name = "RecipePortSoap11")
    public RecipePort getRecipePortSoap11(WebServiceFeature... features) {
        return (RecipePort)super.getPort(new QName("http://binit.blogspot.com/ws/schema/recipe", "RecipePortSoap11"), RecipePort.class, features);
    }

}
