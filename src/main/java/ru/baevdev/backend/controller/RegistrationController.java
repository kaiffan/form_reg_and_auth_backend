package ru.baevdev.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.baevdev.backend.dto.CreateUserDTO;
import ru.baevdev.backend.model.Customer;
import ru.baevdev.backend.service.CustomerService;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {
    CustomerService customerService;

    @PostMapping
    public HttpStatus registrationCustomer(
            @RequestBody CreateUserDTO createUserDTO
    ) {
        Customer customer = Customer.builder()
                .firstName(createUserDTO.getFirstName())
                .lastName(createUserDTO.getLastName())
                .email(createUserDTO.getEmail())
                .login(createUserDTO.getLogin())
                .password(createUserDTO.getPassword())
                .gender(createUserDTO.getGender())
                .age(createUserDTO.getAge())
                .build();
        var idCustomer = customerService.createUser(customer);
        return idCustomer != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }
}
