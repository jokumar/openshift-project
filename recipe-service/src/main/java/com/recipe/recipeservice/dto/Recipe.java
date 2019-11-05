package com.recipe.recipeservice.dto;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	public String category;
	public String name;
	public String description;
	public List<Ingredient> ingredients;
	public String path;
	public Double cost;

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Ingredient> getIngredients() {

		if (ingredients == null) {
			ingredients = new ArrayList<Ingredient>();
		}
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}


