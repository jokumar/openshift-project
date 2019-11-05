package com.recipe.recipeservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPE")
public class UserRecipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column(name = "category")
	public String category;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String desc;
	@Column(name = "created_Date")
	private Date createdDate;
	@Column(name = "updated_date")
	private Date updatedDate;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "ingredients")
	private List<UserIngredient> ingredient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<UserIngredient> getIngredient() {
		if (ingredient == null) {
			ingredient = new ArrayList<UserIngredient>();
		}
		return ingredient;
	}

	public void setIngredient(List<UserIngredient> ingredient) {
		this.ingredient = ingredient;
	}

}


