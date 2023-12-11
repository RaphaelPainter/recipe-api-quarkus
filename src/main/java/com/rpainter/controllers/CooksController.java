package com.rpainter.controllers;

import com.rpainter.config.RootPath;
import com.rpainter.domain.CookFindServiceInterface;
import com.rpainter.model.Chef;
import com.rpainter.model.Ingredient;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;
import java.util.Set;

@Path(RootPath.COOK)
@Authenticated
public class CooksController {

    @Inject
    private CookFindServiceInterface cookFindService;

    @GET
    @Path("")
    @RolesAllowed("admin")
    public List<Chef> findAll() {
        return cookFindService.findAll();
    }
}