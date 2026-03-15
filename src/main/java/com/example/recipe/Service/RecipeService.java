package com.example.recipe.Service;

import com.example.recipe.ErrorHandling.RecipeNotFoundException;
import com.example.recipe.Repo.RecipeRepository;
import com.example.recipe.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService implements IRecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));
    }

    @Override
    public void deleteRecipeById(Long id) {
        if(!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException("Recipe not found, cant delete");
        }
            recipeRepository.findById(id).ifPresent(recipeRepository::delete);


    }

    @Override
    public Recipe updateRecipeById(Long id, Recipe recipe) {
        if(!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException("Recipe not found");
        }
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findByIngredientName(String ingredientName) {
        if(ingredientName == null || ingredientName.isBlank()) {
            throw new RecipeNotFoundException("Recipe not found");
        }
            return recipeRepository.findByIngredientName(ingredientName);
    }

    @Override
    public List<Recipe> findByCalories(int calories) {
        if(calories <= 0) {
            throw new RecipeNotFoundException("Calories can't be less than 0");
        }
        return recipeRepository.findByCalories(calories);
    }

    @Override
    public List<Recipe> findByName(String name) {
        if(name == null || name.isBlank()) {
            throw new RecipeNotFoundException("Recipe not found");
        }
        return recipeRepository.findByName(name);
    }

    @Override
    public List<Recipe> findByPrepTimeMinutes (int prepTimeMinutes) {
        if(prepTimeMinutes <= 0) {
            throw new RecipeNotFoundException("Prep time minutes can't be less than 0");
        }
        return recipeRepository.findByPrepTimeMinutes(prepTimeMinutes);
    }

}
