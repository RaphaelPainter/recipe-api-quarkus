package com.rpainter.controllers;

import com.rpainter.config.RootPath;
import com.rpainter.domain.FoodServiceInterface;
import com.rpainter.domain.RecipeServiceInterface;
import com.rpainter.model.Ingredient;
import com.rpainter.model.Recipe;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.UUID;

@Path(RootPath.RECIPE)
@Authenticated
public class RecipeController {
    @Inject
    private RecipeServiceInterface recipeService;

    @GET
    @Path("")
    @RolesAllowed("admin")
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @GET
    @Path("{id}")
    @RolesAllowed("admin")
    public Recipe findByRecipeById(@PathParam("id") UUID id) {
        return recipeService.findById(id);
    }

    @GET
    @Path("/withIngredient/{id}")
    @RolesAllowed("admin")
    public List<Recipe> findRecipesWithThisIngredient(@PathParam("id") UUID id) {
        return recipeService.findRecipesWithThisIngredient(id);
    }
}
