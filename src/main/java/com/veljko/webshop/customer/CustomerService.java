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
        return customerRepository.findAllByOrderByIdAsc();
    }


    //SAVE CUSTOMER
    public ResponseEntity<String> saveCustomer(Customer customer) {
        //Checks if customer with passed email already exist
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new CustomerEmailAlreadyExistsException("Customer with " + customer.getEmail() + " already exists.");
        }

        //Save customer to database
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }


    //DELETE CUSTOMER
    public ResponseEntity<String> deleteCustomerById(Integer id) {
        //Checks if customer with passed id exist
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFoundException("Did not find customer id - " + id);
        }

        //Delete customer from database
        customerRepository.deleteById(id);
        return new ResponseEntity<>("Customer successfully deleted", HttpStatus.OK);
    }


    //FIND BY ID
    public Customer findCustomerById(Integer id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Did not find customer id - " + id));
    }

    //UPDATE CUSTOMER
    public ResponseEntity<String> updateCustomer(Integer id, Customer newCustomer) {
        Customer oldCustomer = findCustomerById(id);

        //If new passed email doesn't equal to old one then checks if new email belongs to someone
        if (!oldCustomer.getEmail().equals(newCustomer.getEmail())) {
            if (customerRepository.findByEmail(newCustomer.getEmail()).isPresent()) {
                throw new CustomerEmailAlreadyExistsException("Customer with " + newCustomer.getEmail() + " already exists.");
            }
        }

        if (!newCustomer.getId().equals(id)) {
            throw new CustomerNotFoundException(("Customer's id does not match."));
        }

        customerRepository.save(newCustomer);
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
}
