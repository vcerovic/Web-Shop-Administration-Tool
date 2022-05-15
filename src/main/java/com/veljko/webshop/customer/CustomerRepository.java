package com.veljko.webshop.customer;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByOrderByNameAsc();

    Customer findTopByOrderBySpentDesc();

    Customer findTopByOrderByPurchasesDesc();

    Customer findByEmail(String email);

}
