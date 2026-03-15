package com.example.recipe.Service;

import com.example.recipe.model.Recipe;

import java.util.List;

public interface IRecipeService {
    Recipe addRecipe(Recipe recipe);

    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id);

    void deleteRecipeById(Long id);

    Recipe updateRecipeById(Long id, Recipe recipe);

    List<Recipe> findByIngredientName(String ingredientName);

    List<Recipe> findByCalories(int calories);

    List<Recipe> findByName(String name);

    List<Recipe> findByPrepTimeMinutes(int prepTimeMinutes);

}

