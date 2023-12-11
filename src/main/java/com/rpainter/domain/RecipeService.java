package com.rpainter.domain;

import com.rpainter.model.Chef;
import com.rpainter.model.Ingredient;
import com.rpainter.model.Recipe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class RecipeService implements RecipeServiceInterface {

    @Inject
    private PanacheRepository<Recipe> recipeRepository;

    public List<Recipe> findAll() {
        return recipeRepository.listAll();
    }

    @Override
    public Recipe findById(UUID id) {
        return recipeRepository.listAll().stream().filter(it->
             it.id.equals(id)
        ).collect(Collectors.toList()).get(0); //get first
    }

    @Override
    public List<Recipe> findRecipesWithThisIngredient(UUID id) {
        return recipeRepository.listAll().stream().filter(it -> it.ingredients.stream().map(it2-> it2.id).collect(Collectors.toList()).contains(id)).collect(Collectors.toList());
    }
}