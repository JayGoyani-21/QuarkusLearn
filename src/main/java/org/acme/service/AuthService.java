package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import org.acme.DTOs.request.LoginRequest;
import org.acme.DTOs.request.RegisterRequest;
import org.acme.Model.User;

@ApplicationScoped
public class AuthService {

    @Inject
    PasswordService passwordService;

    public void register(RegisterRequest request) {

        if (User.find("email", request.email).firstResult() != null) {
            throw new BadRequestException("Email already registered");
        }

        User user = new User();
        user.name = request.name;
        user.age = request.age;
        user.email = request.email;
        user.password = passwordService.hash(request.password);
        user.role = "USER";

        System.out.println("Reached User");

        user.persist();
    }

    public User authenticate(LoginRequest request) {

        User user = User.find("email", request.email).firstResult();

        if (user == null || !passwordService.matches(request.password, user.password)) {
            throw new BadRequestException("Invalid credentials");
        }

        return user;
    }
}
