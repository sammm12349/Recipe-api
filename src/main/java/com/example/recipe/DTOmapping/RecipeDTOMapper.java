package com.example.recipe.DTOmapping;

import com.example.recipe.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;



@Component
public class RecipeDTOMapper implements Function<Recipe,RecipeDTO> {

    @Override
    public RecipeDTO apply(Recipe recipe) {
        return new RecipeDTO(recipe.getId(),
                recipe.getName(),
                recipe.getServings(),
                recipe.getPrepTimeMinutes(),
                recipe.getCalories(),
                recipe.getIngredient()
                .stream()
                        .map(ingredient ->
                                new IngredientResponse(ingredient.getId(),
                                        ingredient.getName(),
                                        ingredient.getQuantity()
                                                  ))
                        .collect(Collectors.toList())
        );








    }
}
