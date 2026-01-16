package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import io.smallrye.jwt.build.Jwt;
import org.acme.Model.User;

@ApplicationScoped
public class TokenService {

    public String generate(User user) {
        return Jwt.issuer("task-manager")
                .subject(user.email)
                .groups(user.role)
                .expiresIn(3600)
                .sign();
    }
}