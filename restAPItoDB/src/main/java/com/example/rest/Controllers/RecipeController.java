package com.example.rest.Controllers;

import com.example.rest.Models.Recipes;
import com.example.rest.Repo.RecipesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//CRUD
@CrossOrigin( origins = "*")
@RestController
public class RecipeController {
    @Autowired
    private RecipesRepo recipesRepo;

    @GetMapping(value = "/")
    public String sayWelcome() {
        return "Welcome";
    }

    @GetMapping(value = "/recipes", produces = { "application/json" } )
    public List<Recipes> getRecipe() {
        List<Recipes> recipesList = new ArrayList<Recipes>();
        Recipes recipe1 = new Recipes(1, "Baked Salmon", "entree", "Easy", "Feel free to add any extra spices",
                "*****", "45-55 minutes", "Salmon fillet, spices, butter, lemon", true);
        recipesList.add(recipe1);
        recipesList.add(recipe1);
//        recipesList = recipesRepo.findAll();
        return recipesRepo.findAll();
    }

    @PostMapping(value = "/saveRecipe")
    public String saveRecipe(@RequestBody Recipes recipes){
        recipesRepo.save(recipes);
        return "Saved..";
    }

    @PutMapping(value="/update/{id}")
    public String updateRecipe(@PathVariable Integer id, @RequestBody Recipes recipes){
        Recipes updateRecipe = recipesRepo.findById(id).get();
        updateRecipe.setName(recipes.getName());
        updateRecipe.setRating(recipes.getRating());
        updateRecipe.setEaseOfPrep(recipes.getEaseOfPrep());
        updateRecipe.setNotes(recipes.getNotes());
        updateRecipe.setType(recipes.getType());
        updateRecipe.setPrepTime(recipes.getPrepTime());
        updateRecipe.setIngredients(recipes.getIngredients());
        recipesRepo.save(updateRecipe);
        return "Updated..";
    }

    @PutMapping(value="/favorite/{id}")
    public String favoriteRecipe(@PathVariable Integer id){
        Recipes favoriteRecipe = recipesRepo.findById(id).get();
        favoriteRecipe.setFavorite(true);
        recipesRepo.save(favoriteRecipe);
        return "Favorited..";
    }
    @PutMapping(value="/unFavorite/{id}")
    public String unFavoriteRecipe(@PathVariable Integer id){
        Recipes favoriteRecipe = recipesRepo.findById(id).get();
        favoriteRecipe.setFavorite(false);
        recipesRepo.save(favoriteRecipe);
        return "Unfavorited..";
    }


    @DeleteMapping(value = "/delete/{id}")
    public String deleteRecipe(@PathVariable Integer id){
        Recipes deleteRecipe = recipesRepo.findById(id).get();
        recipesRepo.delete(deleteRecipe);
        return "Deleted user with id " + id + "..";
    }

    @GetMapping(value = "/specificRecipe/{id}", produces = { "application/json" } )
    public Recipes getSpecificRecipe(@PathVariable Integer id) {
        Recipes specificRecipe = recipesRepo.findById(id).get();
        Recipes recipe1 = new Recipes(1, "Baked Salmon", "entree", "Easy", "Feel free to add any extra spices", "*****",
                "45-55 minutes", "Salmon fillet, spices, butter, lemon", true);

        return specificRecipe;
    }
}
