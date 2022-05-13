package com.veljko.webshop.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer theEmployee);

    void deleteById(Integer id);
}
