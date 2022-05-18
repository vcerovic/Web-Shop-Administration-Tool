package com.veljko.webshop.customer;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByOrderByNameAsc();

    Optional<Customer> findTopByOrderBySpentDesc();

    Optional<Customer> findTopByOrderByPurchasesDesc();

    Optional<Customer> findByEmail(String email);
}
