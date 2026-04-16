package com.example.recipe.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@ToString(exclude = "ingredient")
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private int servings;
    private int prepTimeMinutes;
    private int calories;

    @OneToMany(mappedBy = "recipe",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredient = new ArrayList<>();


    public Recipe(Long id, String name, int servings, int prepTimeMinutes, int calories, List<Ingredient> ingredient) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.prepTimeMinutes = prepTimeMinutes;
        this.calories = calories;
        this.ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getPrepTimeMinutes() {
        return prepTimeMinutes;
    }

    public void setPrepTimeMinutes(int prepTimeMinutes) {
        this.prepTimeMinutes = prepTimeMinutes;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }


}
