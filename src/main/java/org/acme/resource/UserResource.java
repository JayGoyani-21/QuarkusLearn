package org.acme.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.acme.DTOs.request.UserRequest;
import org.acme.DTOs.response.UserResponse;
import org.acme.service.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserResource {

    @Inject
    UserService userService;

    @POST
    public UserResponse createUser(@Valid UserRequest request) {
        return userService.createUser(request);
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("USER")
    public UserResponse getUserById(@PathParam("id") String id) {
        return userService.getUserById(id);
    }
}
