package com.veljko.webshop.customer;

import com.veljko.webshop.customer.exception.CustomerEmailAlreadyExistsException;
import com.veljko.webshop.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<Customer> findAllCustomers() {
        return customerRepository.findAllByOrderByNameAsc();
    }


    public void saveCustomer(Customer customer) {
        if (validUniqueCustomerEmail(customer.getEmail())) {
            customerRepository.save(customer);
        }
    }


    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }


    public Customer findCustomerById(Integer id) {
        Optional<Customer> result = customerRepository.findById(id);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        } else {
            throw new CustomerNotFoundException("Did not find customer id - " + id);
        }

        return customer;
    }

    public void updateCustomer(Integer id, Customer customer) {
        Customer cust = findCustomerById(id);

        if (cust.getEmail().equals(customer.getEmail())) {
            customerRepository.save(updateCustomer(customer, cust));
        } else {
            if (validUniqueCustomerEmail(customer.getEmail())) {
                customerRepository.save(updateCustomer(customer, cust));
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
        return customerRepository.findTopByOrderBySpentDesc();
    }

    public Customer findCustomerWithMostPurchases() {
        return customerRepository.findTopByOrderByPurchasesDesc();
    }

    public boolean validUniqueCustomerEmail(String email) {
        Customer customerCheck = customerRepository.findByEmail(email);

        if (customerCheck == null) {
            return true;
        } else {
            throw new CustomerEmailAlreadyExistsException("Customer with " + email + " already exists.");
        }

    }

    public long countAll() {
        return customerRepository.count();
    }
}
