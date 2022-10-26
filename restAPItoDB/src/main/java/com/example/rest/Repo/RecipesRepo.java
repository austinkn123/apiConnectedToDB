package com.example.rest.Repo;

import com.example.rest.Models.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepo extends JpaRepository<Recipes, Integer> {


}
