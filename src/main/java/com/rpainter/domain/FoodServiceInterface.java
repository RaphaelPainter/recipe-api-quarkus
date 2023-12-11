package com.rpainter.domain;

import com.rpainter.model.Chef;
import com.rpainter.model.Ingredient;

import java.util.List;

public interface FoodServiceInterface {
    public List<Ingredient> findAll();

    List<Ingredient> findSeasonalFood();
}
