package org.acme.DTOs.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "Name is required")
    public String name;

    @Min(value = 18, message = "Age must be at least 18")
    public int age;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    public String email;
}
