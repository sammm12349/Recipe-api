package com.example.recipe.DTOmapping;


import java.util.List;

public record RecipeDTO(
        Long id,
        String name,
        int servings,
        int prepTimeMinutes,
        int calories,
        List<IngredientResponse>ingredient
) {
}
