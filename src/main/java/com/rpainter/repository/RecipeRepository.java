package com.rpainter.repository;

import com.rpainter.model.Ingredient;
import com.rpainter.model.Recipe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;

@Singleton
public class RecipeRepository implements PanacheRepository<Recipe> {

}
