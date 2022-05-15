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

    public void updateCustomer(Integer id, Customer inCustomer) {
        Customer customer = findCustomerById(id);

        if (customer.getEmail().equals(inCustomer.getEmail())) {
            customerRepository.save(updateCustomer(inCustomer, customer));
        } else {
            if (validUniqueCustomerEmail(inCustomer.getEmail())) {
                customerRepository.save(updateCustomer(inCustomer, customer));
            }
        }

    }

    private Customer updateCustomer(Customer oldCustomer, Customer newCustomer) {
        newCustomer.setId(oldCustomer.getId());
        newCustomer.setName(oldCustomer.getName());
        newCustomer.setAddress(oldCustomer.getAddress());
        newCustomer.setEmail(oldCustomer.getEmail());
        newCustomer.setPurchases(oldCustomer.getPurchases());
        newCustomer.setSpent(oldCustomer.getSpent());

        return newCustomer;
    }

    public Customer findCustomerWithMostMoneySpent() {
        Optional<Customer> customer = customerRepository.findTopByOrderBySpentDesc();

        return customer.orElse(null);

    }

    public Customer findCustomerWithMostPurchases() {
        Optional<Customer> customer = customerRepository.findTopByOrderByPurchasesDesc();

        return customer.orElse(null);
    }

    public boolean validUniqueCustomerEmail(String email) {
        if (customerRepository.findByEmail(email).isPresent()) {
            throw new CustomerEmailAlreadyExistsException("Customer with " + email + " already exists.");
        } else {
            return true;
        }
    }

    public long countAll() {
        return customerRepository.count();
    }
}
