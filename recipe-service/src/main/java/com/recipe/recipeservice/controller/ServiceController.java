package com.recipe.recipeservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipeservice.dto.Ingredient;
import com.recipe.recipeservice.dto.Recipe;
import com.recipe.service.RecipeService;

@RestController
@RequestMapping("/geeks18/recipe")
public class ServiceController {
	@Resource
	RecipeService recipeServiceImpl;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ArrayList<Recipe>> getAllRecipe(HttpServletRequest request) {

		ArrayList<Recipe> recipelist = (ArrayList<Recipe>) recipeServiceImpl.retrieveAllRecipe();
		return ResponseEntity.status(HttpStatus.OK).body(recipelist);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Recipe> createRecipe(HttpServletRequest request, @RequestBody Recipe recipe) {

		return ResponseEntity.status(HttpStatus.OK).body(recipeServiceImpl.createRecipe(recipe));
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/ingredient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Ingredient> createRecipe(HttpServletRequest request,
			@RequestBody Ingredient ingredient) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeServiceImpl.addIngredients(ingredient));
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/ingredient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<Ingredient>> createRecipe(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeServiceImpl.getAllIngredients());
	}

}


