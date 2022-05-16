package com.veljko.webshop.customer;

import com.veljko.webshop.customer.exception.CustomerEmailAlreadyExistsException;
import com.veljko.webshop.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    //LIST ALL CUSTOMERS
    public List<Customer> findAllCustomers() {
        return customerRepository.findAllByOrderByNameAsc();
    }


    //SAVE CUSTOMER
    public ResponseEntity<String> saveCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new CustomerEmailAlreadyExistsException("Customer with " + customer.getEmail() + " already exists.");
        }

        customerRepository.save(customer);
        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }


    //DELETE CUSTOMER
    public ResponseEntity<String> deleteCustomerById(Integer id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFoundException("Did not find customer id - " + id);
        }

        customerRepository.deleteById(id);
        return new ResponseEntity<>("Customer successfully deleted", HttpStatus.OK);
    }


    //FIND BY ID
    public Customer findCustomerById(Integer id) {
        Optional<Customer> result = customerRepository.findById(id);

        Customer customer;

        if (result.isEmpty()) {
            throw new CustomerNotFoundException("Did not find customer id - " + id);
        }

        customer = result.get();

        return customer;
    }

    //UPDATE CUSTOMER
    public ResponseEntity<String> updateCustomer(Integer id, Customer inCustomer) {
        Customer customer = findCustomerById(id);

        if (!customer.getEmail().equals(inCustomer.getEmail())) {
            if (customerRepository.findByEmail(inCustomer.getEmail()).isPresent()) {
                throw new CustomerEmailAlreadyExistsException("Customer with " + inCustomer.getEmail() + " already exists.");
            }
        }

        customerRepository.save(updateAndReturnCustomer(inCustomer, customer));
        return new ResponseEntity<>("Customer successfully changed", HttpStatus.OK);
    }


    //FIND WITH MOST MONEY SPENT
    public Customer findCustomerWithMostMoneySpent() {
        Optional<Customer> customer = customerRepository.findTopByOrderBySpentDesc();

        return customer.orElse(null);

    }

    //FIND WITH MOST PURCHASES
    public Customer findCustomerWithMostPurchases() {
        Optional<Customer> customer = customerRepository.findTopByOrderByPurchasesDesc();

        return customer.orElse(null);
    }


    //COUNT ALL CUSTOMERS
    public long countAllCustomers() {
        return customerRepository.count();
    }


    private Customer updateAndReturnCustomer(Customer oldCustomer, Customer newCustomer) {
        newCustomer.setId(oldCustomer.getId());
        newCustomer.setName(oldCustomer.getName());
        newCustomer.setAddress(oldCustomer.getAddress());
        newCustomer.setEmail(oldCustomer.getEmail());
        newCustomer.setPurchases(oldCustomer.getPurchases());
        newCustomer.setSpent(oldCustomer.getSpent());

        return newCustomer;
    }
}
