package com.example.recipe.DTOmapping;

public record IngredientResponse(
        Long id,
        String name,
        String quantity
) {
}
