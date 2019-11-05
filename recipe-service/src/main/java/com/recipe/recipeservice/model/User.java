package com.recipe.recipeservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public String userId;
	@Column
	public String name;

	@Column
	public String address;

	@Column
	public String email;

	@Column
	public String follower;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	public List<UserRecipe> recipeList;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	public List<UserIngredient> ingredientList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFollower() {
		return follower;
	}

	public void setFollower(String follower) {
		this.follower = follower;
	}

	public List<UserRecipe> getRecipeList() {
		if (recipeList == null) {
			recipeList = new ArrayList<UserRecipe>();
		}
		return recipeList;
	}

	public void setRecipeList(List<UserRecipe> recipeList) {
		this.recipeList = recipeList;
	}

	public List<UserIngredient> getIngredientList() {
		if (ingredientList == null) {
			ingredientList = new ArrayList<UserIngredient>();
		}
		return ingredientList;
	}

	public void setIngredientList(List<UserIngredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

}


