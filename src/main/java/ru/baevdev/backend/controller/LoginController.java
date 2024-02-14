package ru.baevdev.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.baevdev.backend.dto.LoginCustomerDTO;
import ru.baevdev.backend.service.CustomerService;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    CustomerService customerService;

    @GetMapping
    public HttpStatus loginCustomer(
        @RequestBody LoginCustomerDTO loginCustomerDTO
    ) {
        var id = customerService.loginCustomer(loginCustomerDTO);
        if(id == null) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
