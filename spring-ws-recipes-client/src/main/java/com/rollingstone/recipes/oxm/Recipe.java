
package com.rollingstone.recipes.oxm;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeId"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeName"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeDescripton"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}createdBy"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipeType"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}visitorCount"/>
 *         &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}process"/>
 *         &lt;sequence>
 *           &lt;element ref="{http://binit.blogspot.com/ws/schema/recipe}recipe_ingredients"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "recipeId",
    "recipeName",
    "recipeDescripton",
    "createdBy",
    "recipeType",
    "visitorCount",
    "process",
    "recipeIngredients"
})
@XmlRootElement(name = "recipe")
public class Recipe {

    protected int recipeId;
    @XmlElement(required = true)
    protected String recipeName;
    @XmlElement(required = true)
    protected String recipeDescripton;
    @XmlElement(required = true)
    protected String createdBy;
    @XmlElement(required = true)
    protected String recipeType;
    protected int visitorCount;
    @XmlElement(required = true)
    protected String process;
    @XmlElement(name = "recipe_ingredients", required = true)
    protected List<RecipeIngredients> recipeIngredients;

	public List<RecipeIngredients> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredients> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	/**
     * Gets the value of the recipeId property.
     * 
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Sets the value of the recipeId property.
     * 
     */
    public void setRecipeId(int value) {
        this.recipeId = value;
    }

    /**
     * Gets the value of the recipeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets the value of the recipeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipeName(String value) {
        this.recipeName = value;
    }

    /**
     * Gets the value of the recipeDescripton property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipeDescripton() {
        return recipeDescripton;
    }

    /**
     * Sets the value of the recipeDescripton property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipeDescripton(String value) {
        this.recipeDescripton = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the recipeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipeType() {
        return recipeType;
    }

    /**
     * Sets the value of the recipeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipeType(String value) {
        this.recipeType = value;
    }

    /**
     * Gets the value of the visitorCount property.
     * 
     */
    public int getVisitorCount() {
        return visitorCount;
    }

    /**
     * Sets the value of the visitorCount property.
     * 
     */
    public void setVisitorCount(int value) {
        this.visitorCount = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcess(String value) {
        this.process = value;
    }
}
