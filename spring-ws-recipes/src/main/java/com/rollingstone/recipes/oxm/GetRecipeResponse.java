package com.rollingstone.recipes.oxm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.rollingstone.recipes.domain.Recipe;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "code",
    "recipe"
})
@XmlRootElement(name = "getRecipeResponse")
public class GetRecipeResponse {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected Recipe recipe;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the recipe property.
     * 
     * @return
     *     possible object is
     *     {@link Recipe }
     *     
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets the value of the recipe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recipe }
     *     
     */
    public void setRecipe(Recipe value) {
        this.recipe = value;
    }

}
