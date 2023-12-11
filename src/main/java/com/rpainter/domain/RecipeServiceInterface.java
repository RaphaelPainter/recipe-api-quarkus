package com.rpainter.domain;

import com.rpainter.model.Chef;
import com.rpainter.model.Recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeServiceInterface {
    public List<Recipe> findAll();

    Recipe findById(UUID id);

    List<Recipe> findRecipesWithThisIngredient(UUID id);
}
