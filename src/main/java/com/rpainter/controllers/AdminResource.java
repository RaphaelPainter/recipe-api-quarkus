package com.rpainter.controllers;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;

@Path("/auth")
@Authenticated
public class AdminResource {
    @GET
    @Path("/permit-all")
    @PermitAll
    public String permitAll() {
        return "ok";
    }

    @GET
    @Path("/only-admin")
    @RolesAllowed("admin")
    public String onlyAdmin() {
        return "ok";
    }


}
