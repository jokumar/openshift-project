package com.recipe.cost.recipecost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.cost.recipecost.Ingredient;

@RestController
@RequestMapping("/geeks18")
public class CostController {
	@Value("${recipe.cost.index}")
	private Integer costIndex;

	private static final Logger LOGGER = LoggerFactory.getLogger(CostController.class);

	@RequestMapping(value = "/cost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Double> getCostOfRecipe(HttpServletRequest request,
			@RequestBody List<Ingredient> ingredientList) {
		Double cost = 0.0;

		LOGGER.debug("Cost Index is " + costIndex);

		for (Ingredient ingredient : ingredientList) {
			Double ppu = ingredient.getPricePerUnit();
			if (ppu == null) {
				ppu = 0.0;
			}

			Double quantity = ingredient.getQuantity();
			if (quantity == null) {
				quantity = 0.0;
			}

			cost = cost + (ppu * quantity * costIndex);
		}

		return ResponseEntity.status(HttpStatus.OK).body(cost);
	}

}


