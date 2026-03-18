package com.example.recipe.Service;

import com.example.recipe.DTOmapping.RecipeDTO;
import com.example.recipe.model.Recipe;

import java.util.List;

public interface IRecipeService {
    RecipeDTO addRecipe(Recipe recipe);

    List<RecipeDTO> getAllRecipes();

    RecipeDTO getRecipeById(Long id);

    void deleteRecipeById(Long id);

    RecipeDTO updateRecipeById(Long id, Recipe recipe);

    List<RecipeDTO> findByIngredientName(String ingredientName);

    List<RecipeDTO> findByCalories(int calories);

    List<RecipeDTO> findByName(String name);

    List<RecipeDTO> findByPrepTimeMinutes(int prepTimeMinutes);

}

