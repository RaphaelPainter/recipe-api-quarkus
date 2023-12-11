package com.rpainter.repository;

import com.rpainter.model.Chef;
import com.rpainter.model.Ingredient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;

@Singleton
public class FoodRepository implements PanacheRepository<Ingredient> {

}
