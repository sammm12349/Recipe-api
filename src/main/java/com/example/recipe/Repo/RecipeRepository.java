package com.example.recipe.Repo;

import com.example.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByName(String name);
    List<Recipe> findByCalories(int calories);
    List<Recipe> findByIngredientName(String ingredientName);


    List<Recipe> findByPrepTimeMinutes(int prepTimeMinutes);
}
