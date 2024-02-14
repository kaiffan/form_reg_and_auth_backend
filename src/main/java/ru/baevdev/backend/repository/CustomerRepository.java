package ru.baevdev.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.baevdev.backend.model.Customer;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    @Query("select count(c.login) = 1 from Customer as c where c.login=?1")
    boolean findExistByLogin(String login);

    @Query("select count(c.email) = 1 from Customer as c where c.email=?1")
    boolean findExistByEmail(String email);
}
