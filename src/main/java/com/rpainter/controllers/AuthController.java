package com.rpainter.controllers;

import com.rpainter.domain.services.auth.PBKDF2Encoder;
import com.rpainter.domain.services.auth.TokenUtils;
import com.rpainter.model.auth.AuthRequest;
import com.rpainter.model.auth.AuthResponse;
import com.rpainter.model.auth.AuthUser;
import com.rpainter.model.misc.Message;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path(RootPath.AUTH)
public class AuthController {

    @Inject
    PBKDF2Encoder passwordEncoder;

    @ConfigProperty(name = "com.ard333.quarkusjwt.jwt.duration") public Long duration;
    @ConfigProperty(name = "mp.jwt.verify.issuer") public String issuer;

    @PermitAll
    @POST @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login( AuthRequest authRequest) {
        AuthUser u = AuthUser.findByUsername(authRequest.username);
        if (u != null && u.password.equals(passwordEncoder.encode(authRequest.password))) {
            try {
                return Response
                        .status(Response.Status.OK)
                        .entity(new AuthResponse(TokenUtils.generateToken(u.username, u.roles, duration, issuer)))
                        .build();

            } catch (Exception e) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @RolesAllowed("USER")
    @GET @Path("/user") @Produces(MediaType.APPLICATION_JSON)
    public Response user() {
        return Response.ok(new Message("Content for user")).build();
    }

    @RolesAllowed("ADMIN")
    @GET @Path("/admin") @Produces(MediaType.APPLICATION_JSON)
    public Response admin() {
        return Response.ok(new Message("Content for admin")).build();
    }

    @RolesAllowed({"USER", "ADMIN"})
    @GET @Path("/user-or-admin") @Produces(MediaType.APPLICATION_JSON)
    public Response userOrAdmin() {
        return Response.ok(new Message("Content for user or admin")).build();
    }
}
