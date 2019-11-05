package com.recipe.recipeservice.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.recipeservice.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {

}


