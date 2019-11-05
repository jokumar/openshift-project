package com.recipe.recipeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.recipe")
public class RecipeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeServiceApplication.class, args);
	}

}
