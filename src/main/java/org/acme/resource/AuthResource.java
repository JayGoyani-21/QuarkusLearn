package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.DTOs.request.LoginRequest;
import org.acme.DTOs.request.RegisterRequest;
import org.acme.service.AuthService;
import org.acme.service.TokenService;

import java.util.logging.Logger;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @Inject
    TokenService tokenService;

    @GET
    @Path("/")
    public String check(){
        return "Jay";
    }

    @POST
    @Path("/register")
    public String register(@Valid RegisterRequest request) {
        System.out.println("reached");
        Logger Log = Logger.getLogger("AuthResource.class");
        Log.info("ReachedLog");
        authService.register(request);
        return "User registered successfully";
    }

    @POST
    @Path("/login")
    public String login(@Valid LoginRequest request) {
        var user = authService.authenticate(request);
        return tokenService.generate(user);
    }
}
