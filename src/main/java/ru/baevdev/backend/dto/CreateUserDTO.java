package ru.baevdev.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import ru.baevdev.backend.model.enumeration.Age;
import ru.baevdev.backend.model.enumeration.Gender;

@Data
public class CreateUserDTO {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{2,15}")
    private String firstName;

    //TODO:Проверка на двойные фамилии
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{2,15}")
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{6,}$")
    private String login;

    @NotBlank
    @Pattern(regexp = "^.{8,}$")
    private String password;
    private Gender gender;
    private Age age;
}
