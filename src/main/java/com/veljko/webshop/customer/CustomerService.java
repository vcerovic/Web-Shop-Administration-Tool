package com.veljko.webshop.customer;

import com.veljko.webshop.customer.exception.CustomerEmailAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public List<Customer> findAll() {
        return repository.findAllByOrderByNameAsc();
    }


    public void save(Customer customer) {
        if (validUniqueCustomerEmail(customer.getEmail())) {
            repository.save(customer);
        }
    }


    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


    public Customer findById(Integer id) {
        Optional<Customer> result = repository.findById(id);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        } else {
            throw new RuntimeException("Did not find customer id - " + id);
        }

        return customer;
    }

    public void update(Integer id, Customer customer) {
        Customer cust = findById(id);

        if (cust.getEmail().equals(customer.getEmail())) {
            repository.save(updateCustomer(customer, cust));
        } else {
            if (validUniqueCustomerEmail(customer.getEmail())) {
                repository.save(updateCustomer(customer, cust));
            }
        }


    }

    private Customer updateCustomer(Customer customer, Customer cust) {
        cust.setId(customer.getId());
        cust.setName(customer.getName());
        cust.setAddress(customer.getAddress());
        cust.setEmail(customer.getEmail());
        cust.setPurchases(customer.getPurchases());
        cust.setSpent(customer.getSpent());

        return cust;
    }

    public Customer findCustomerWithMostMoneySpent() {
        return repository.findTopByOrderBySpentDesc();
    }

    public Customer findCustomerWithMostPurchases() {
        return repository.findTopByOrderByPurchasesDesc();
    }

    public boolean validUniqueCustomerEmail(String email) {
        Customer customerCheck = repository.findByEmail(email);

        if (customerCheck == null) {
            return true;
        } else {
            throw new CustomerEmailAlreadyExists("Customer with " + email + " already exists.");
        }

    }

    public long countAll() {
        return repository.count();
    }
}
