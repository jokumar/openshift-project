package com.recipe.recipeservice.dto;

public class Ingredient {

	private String name;
	private String measuredType;
	private Double quantity;
	private Double pricePerUnit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasuredType() {
		return measuredType;
	}

	public void setMeasuredType(String measuredType) {
		this.measuredType = measuredType;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}


