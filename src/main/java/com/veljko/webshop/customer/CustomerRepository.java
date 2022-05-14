package com.veljko.webshop.customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findTopByOrderBySpentDesc();

    Customer findTopByOrderByPurchasesDesc();

}
