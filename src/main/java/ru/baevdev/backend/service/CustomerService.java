package ru.baevdev.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baevdev.backend.dto.LoginCustomerDTO;
import ru.baevdev.backend.model.Customer;
import ru.baevdev.backend.repository.CustomerRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    CustomerRepository customerRepository;

    public UUID createUser(Customer customer) {
        if (customerRepository.findExistByLogin(customer.getLogin())) {
            throw new IllegalArgumentException("This login is exists" + customer.getLogin());
        }

        if (customerRepository.findExistByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("This email is exists" + customer.getEmail());
        }

        return customerRepository.save(customer).getId();
    }

    public UUID loginCustomer(LoginCustomerDTO loginCustomerDTO) {
        

        return UUID.randomUUID();
    }
}
