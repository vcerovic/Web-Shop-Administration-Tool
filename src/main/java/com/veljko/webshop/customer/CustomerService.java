package com.veljko.webshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService{

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public List<Customer> findAll(){
        return (List<Customer>) repository.findAll();
    }


    public Customer save(Customer customer){
        return repository.save(customer);
    }


    public void deleteById(Integer id){
        repository.deleteById(id);
    }


    public Customer findById(Integer id){
        Optional<Customer> result = repository.findById(id);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        }
        else {
            throw new RuntimeException("Did not find customer id - " + id);
        }

        return customer;
    }

    public Customer update(Integer id, Customer customer){
        Customer cust = findById(id);
        cust.setId(customer.getId());
        cust.setName(customer.getName());
        cust.setAddress(customer.getAddress());
        cust.setEmail(customer.getEmail());
        cust.setPurchases(customer.getPurchases());
        cust.setSpent(customer.getSpent());

        return repository.save(cust);
    }


}
