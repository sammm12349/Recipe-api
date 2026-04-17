package com.example.recipe.Service;

import com.example.recipe.DTOmapping.RecipeDTO;
import com.example.recipe.DTOmapping.RecipeDTOMapper;
import com.example.recipe.Repo.RecipeRepository;
import com.example.recipe.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
     RecipeRepository recipeRepository;

    @Mock
     RecipeDTOMapper recipeDTOMapper;

    @InjectMocks
     RecipeService recipeService;

    Recipe recipe;
    Recipe savedrecipe;
    RecipeDTO recipeDTO;

    @BeforeEach
    void setUp() {
        recipe = new Recipe(null,"Pasta",2,45,1700,new ArrayList<>());
        savedrecipe = new Recipe(1L,"Pasta",2,45,1700,new ArrayList<>());
        recipeDTO = new RecipeDTO(1L,"Pasta",2,45,1700,new ArrayList<>());
    }

    @Test
    void addRecipeSuccessfully() {

        when(recipeRepository.save(recipe)).thenReturn(savedrecipe);
        when(recipeDTOMapper.apply(savedrecipe)).thenReturn(recipeDTO);

        RecipeDTO result = recipeService.addRecipe(recipe);

        assertNotNull(result);
        assertEquals("Pasta", result.name());
        verify(recipeRepository).save(recipe);
        verify(recipeDTOMapper).apply(savedrecipe);



    }

    @Test
    void getAllRecipesSuccessfully() {
        when(recipeRepository.findAll()).thenReturn(List.of(savedrecipe));
        when(recipeDTOMapper.apply(savedrecipe)).thenReturn(recipeDTO);

        List<RecipeDTO> result = recipeService.getAllRecipes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Pasta", result.get(0).name());
        verify(recipeRepository).findAll();
        verify(recipeDTOMapper).apply(savedrecipe);

    }


    @Test
    void getRecipeByIdSuccessfully() {
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(savedrecipe));
        when(recipeDTOMapper.apply(savedrecipe)).thenReturn(recipeDTO);

        RecipeDTO result = recipeService.getRecipeById(1L);

        assertNotNull(result);
        assertEquals("Pasta", result.name());
        verify(recipeRepository).findById(1L);
        verify(recipeDTOMapper).apply(savedrecipe);

    }

    @Test
    void updateRecipeSuccessfully() {
        when(recipeRepository.existsById(1L)).thenReturn(true);
        when(recipeRepository.save(recipe)).thenReturn(savedrecipe);
        when(recipeDTOMapper.apply(savedrecipe)).thenReturn(recipeDTO);




        RecipeDTO updatedResult = recipeService.updateRecipeById(1L,recipe);

        assertNotNull(updatedResult);
        assertEquals("Pasta", updatedResult.name());
        verify(recipeRepository).existsById(1L);
        verify(recipeRepository).save(recipe);
        verify(recipeDTOMapper).apply(savedrecipe);




    }

    @Test void deleteRecipeSuccessfully() {
        when(recipeRepository.existsById(1L)).thenReturn(true);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(savedrecipe));
        doNothing().when(recipeRepository).delete(savedrecipe);

        recipeService.deleteRecipeById(1L);


        verify(recipeRepository).existsById(1L);
        verify(recipeRepository).findById(1L);
        verify(recipeRepository).delete(savedrecipe);

    }
  
}