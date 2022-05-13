package com.veljko.webshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAll(){
        return (List<Customer>) repository.findAll();
    }

    @Override
    public void save(Customer customer){
        repository.save(customer);
    }

    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    @Override
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


}
