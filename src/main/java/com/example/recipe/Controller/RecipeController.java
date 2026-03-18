package com.example.recipe.Controller;


import com.example.recipe.DTOmapping.RecipeDTO;
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
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
       List<RecipeDTO> recipes = recipeService.getAllRecipes();
       return new ResponseEntity<>(recipes, HttpStatus.OK);

    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
        RecipeDTO recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody Recipe recipe) {
        RecipeDTO savedRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);


    }
    @PutMapping("/update/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        RecipeDTO updaterecipe = recipeService.updateRecipeById(id, recipe);
        return new ResponseEntity<>(updaterecipe, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/ingredient")
    public ResponseEntity<List<RecipeDTO>> getRecipeByIngredientName(@RequestParam String ingredientName) {
        List<RecipeDTO> recipes = recipeService.findByIngredientName(ingredientName);
        return new ResponseEntity<>(recipes, HttpStatus.OK);

    }
    @GetMapping("/find/calories")
    public ResponseEntity<List<RecipeDTO>> getRecipeByCalories(@RequestParam int calories) {
        List<RecipeDTO> recipes = recipeService.findByCalories(calories);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    @GetMapping("/find/name")
    public ResponseEntity<List<RecipeDTO>> getRecipeByRecipeName(@RequestParam String recipeName) {
        List<RecipeDTO> recipes = recipeService.findByName(recipeName);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
    @GetMapping("/find/preptime")
    public ResponseEntity<List<RecipeDTO>>getRecipeByPrepTime(@RequestParam int prepTime) {
        List<RecipeDTO> recipes = recipeService.findByPrepTimeMinutes(prepTime);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }




    }


