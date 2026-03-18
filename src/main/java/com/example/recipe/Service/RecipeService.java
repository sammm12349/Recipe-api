package com.example.recipe.Service;

import com.example.recipe.DTOmapping.RecipeDTO;
import com.example.recipe.DTOmapping.RecipeDTOMapper;
import com.example.recipe.ErrorHandling.RecipeNotFoundException;
import com.example.recipe.Repo.RecipeRepository;
import com.example.recipe.model.Recipe;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class RecipeService implements IRecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeDTOMapper recipeDTOMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeDTOMapper recipeDTOMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeDTOMapper = recipeDTOMapper;
    }


    @Override
    public RecipeDTO addRecipe(Recipe recipe) {
        return recipeDTOMapper.apply(recipeRepository.save(recipe));
    }

    @Override
    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .map(recipeDTOMapper)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));
    }

    @Override
    public void deleteRecipeById(Long id) {
        if(!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException("Recipe not found, cant delete");
        }
            recipeRepository.findById(id).ifPresent(recipeRepository::delete);


    }

    @Override
    public RecipeDTO updateRecipeById(Long id, Recipe recipe) {
        if(!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException("Recipe not found");
        }
        recipe.setId(id);
        return recipeDTOMapper.apply(recipeRepository.save(recipe));
    }

    @Override
    public List<RecipeDTO> findByIngredientName(String ingredientName) {
        if(ingredientName == null || ingredientName.isBlank()) {
            throw new RecipeNotFoundException("Recipe not found");
        }
            return recipeRepository.findByIngredientName(ingredientName)
                    .stream()
                    .map(recipeDTOMapper)
                    .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findByCalories(int calories) {
        if(calories <= 0) {
            throw new RecipeNotFoundException("Calories can't be less than 0");
        }
        return recipeRepository.findByCalories(calories)
                .stream()
                .map(recipeDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findByName(String name) {
        if(name == null || name.isBlank()) {
            throw new RecipeNotFoundException("Recipe not found");
        }
        return recipeRepository.findByName(name)
                .stream()
                .map(recipeDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> findByPrepTimeMinutes (int prepTimeMinutes) {
        if(prepTimeMinutes <= 0) {
            throw new RecipeNotFoundException("Prep time minutes can't be less than 0");
        }
        return recipeRepository.findByPrepTimeMinutes(prepTimeMinutes)
                .stream()
                .map(recipeDTOMapper)
                .collect(Collectors.toList());
    }

}
