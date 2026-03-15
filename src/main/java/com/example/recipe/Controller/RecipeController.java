package com.example.recipe.Controller;


import com.example.recipe.Service.IRecipeService;

import com.example.recipe.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
  private final IRecipeService recipeService;


    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
       List<Recipe> recipes = recipeService.getAllRecipes();
       return new ResponseEntity<>(recipes, HttpStatus.OK);

    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);


    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        Recipe updaterecipe = recipeService.updateRecipeById(id, recipe);
        return new ResponseEntity<>(updaterecipe, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/ingredient")
    public ResponseEntity<List<Recipe>> getRecipeByIngredientName(@RequestParam String ingredientName) {
        List<Recipe> recipes = recipeService.findByIngredientName(ingredientName);
        return new ResponseEntity<>(recipes, HttpStatus.OK);

    }
    @GetMapping("/find/calories")
    public ResponseEntity<List<Recipe>> getRecipeByCalories(@RequestParam int calories) {
        List<Recipe> recipes = recipeService.findByCalories(calories);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    @GetMapping("/find/name")
    public ResponseEntity<List<Recipe>> getRecipeByRecipeName(@RequestParam String recipeName) {
        List<Recipe> recipes = recipeService.findByName(recipeName);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    @GetMapping("/find/preptime")
    public ResponseEntity<List<Recipe>> getRecipeByPrepTime(@RequestParam int prepTime) {
        List<Recipe> recipes = recipeService.findByPrepTimeMinutes(prepTime);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }




    }


