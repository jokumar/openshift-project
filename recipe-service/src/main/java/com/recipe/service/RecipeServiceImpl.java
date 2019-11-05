package com.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.recipeservice.dto.Ingredient;
import com.recipe.recipeservice.dto.Recipe;
import com.recipe.recipeservice.model.User;
import com.recipe.recipeservice.model.UserIngredient;
import com.recipe.recipeservice.model.UserRecipe;
import com.recipe.recipeservice.repositories.UserRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeServiceImpl.class);
	@Resource
	UserRepository userRepo;
	String userId = "joy";// To be dynamic
	@Autowired
	KeycloakRestTemplate keycloakRestTemplate;

	@Override
	public List<Recipe> retrieveAllRecipe() {
		List<Recipe> recipeList = new ArrayList<>();
		User user = userRepo.findById(userId).get();
		// Retrieve all the task by userid
		List<UserRecipe> recipelist = user.getRecipeList();
		for (UserRecipe recipe : recipelist) {
			Recipe r = new Recipe();
			r.setName(recipe.getName());
			r.setDescription(recipe.getDesc());

			List<Ingredient> ingredients = new ArrayList<>();
			for (UserIngredient uig : recipe.getIngredient()) {
				Ingredient ig = new Ingredient();
				ig.setMeasuredType(uig.getMeasuredType());
				ig.setName(uig.getName());
				ig.setPricePerUnit(uig.getPricePerUnit());
				ig.setQuantity(uig.getQuantity());
				ingredients.add(ig);
			}
			r.setIngredients(ingredients);
			// REMOVE
			Double cost = keycloakRestTemplate
					.postForEntity("http://recipe-cost/geeks18/cost/", ingredients,
							Double.class)
					.getBody();
			r.setCost(cost);

			recipeList.add(r);
		}
		return recipeList;

	}

	@Override
	public Recipe createRecipe(Recipe recipe) {
		UserRecipe ur = new UserRecipe();
		ur.setCategory(recipe.getCategory());
		ur.setDesc(recipe.getDescription());
		ur.setName(recipe.getName());

		List<Ingredient> list_ig = recipe.getIngredients();
		List<UserIngredient> entityIgList = new ArrayList<>();
		for (Ingredient ig : list_ig) {
			UserIngredient uig = new UserIngredient();
			uig.setName(ig.getName());
			uig.setMeasuredType(ig.getMeasuredType());
			uig.setPricePerUnit(ig.getPricePerUnit());
			uig.setQuantity(ig.getQuantity());
			entityIgList.add(uig);
		}
		ur.setIngredient(entityIgList);
		User user = userRepo.findById(userId).get();
		List<UserRecipe> list = user.getRecipeList();
		list.add(ur);
		user.setRecipeList(list);
		try {
			userRepo.save(user);
		} catch (Exception e) {
			LOGGER.debug("Error while saving Recipe", e);
			recipe = null;
		}
		return recipe;
	}

	@Override
	public Ingredient addIngredients(Ingredient ig) {
		UserIngredient ingredient = new UserIngredient();
		ingredient.setMeasuredType(ig.getMeasuredType());
		ingredient.setName(ig.getName());
		ingredient.setPricePerUnit(ig.getPricePerUnit());
		ingredient.setQuantity(ig.getQuantity());

		User user = userRepo.findById(userId).get();
		List<UserIngredient> list = user.getIngredientList();
		list.add(ingredient);
		user.setIngredientList(list);

		try {
			userRepo.save(user);
		} catch (Exception e) {
			LOGGER.debug("Error while saving Ingredients", e);
			ig = null;
		}
		return ig;
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		List<Ingredient> ingredientsList = new ArrayList<>();
		User user = userRepo.findById(userId).get();
		// Retrieve all the task by userid
		List<UserIngredient> igList = user.getIngredientList();
		for (UserIngredient ingredient : igList) {
			Ingredient i = new Ingredient();
			i.setName(ingredient.getName());
			i.setMeasuredType(ingredient.getMeasuredType());
			i.setPricePerUnit(ingredient.getPricePerUnit());
			i.setQuantity(ingredient.getQuantity());
			ingredientsList.add(i);
		}
		return ingredientsList;
	}

}


