package org.acme.DTOs.request;

import jakarta.validation.constraints.*;

public class RegisterRequest {

    @NotBlank
    public String name;

    @Min(18)
    public int age;

    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String password;
}