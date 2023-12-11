package com.rpainter.controllers;

import com.rpainter.config.RootPath;
import com.rpainter.domain.CookFindServiceInterface;
import com.rpainter.domain.FoodServiceInterface;
import com.rpainter.model.Chef;
import com.rpainter.model.Ingredient;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path(RootPath.INGREDIENT)
@Authenticated
public class FoodController {

    @Inject
    private FoodServiceInterface foodService;

    @GET
    @Path("")
    @RolesAllowed("admin")
    public List<Ingredient> findSeasonalFood() {
        return foodService.findSeasonalFood();
    }
}