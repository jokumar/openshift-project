package com.recipe.service;

import java.util.List;

import com.recipe.recipeservice.dto.Ingredient;
import com.recipe.recipeservice.dto.Recipe;

public interface RecipeService {

	public List<Recipe> retrieveAllRecipe();

	public Recipe createRecipe(Recipe recipe);

	public Ingredient addIngredients(Ingredient ingredient);

	public List<Ingredient> getAllIngredients();

}


