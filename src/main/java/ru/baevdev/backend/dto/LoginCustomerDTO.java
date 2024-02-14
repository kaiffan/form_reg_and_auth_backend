package ru.baevdev.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginCustomerDTO {
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @Pattern(regexp = "^[a-zA-Z0-9]{6,}$")
    private String login;

    @NotBlank
    @Pattern(regexp = "^.{8,}$")
    private String password;
}
