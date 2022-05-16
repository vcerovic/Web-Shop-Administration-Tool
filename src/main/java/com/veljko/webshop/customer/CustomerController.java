package com.veljko.webshop.customer;

import com.veljko.webshop.customer.exception.CustomerEmailAlreadyExistsException;
import com.veljko.webshop.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listAllCustomers(Model model) {
        List<Customer> customers = customerService.findAllCustomers();
        Customer customerWithMostMoneySpent = customerService.findCustomerWithMostMoneySpent();
        Customer customerWithMostPurchases = customerService.findCustomerWithMostPurchases();
        long totalCustomers = customerService.countAllCustomers();

        model.addAttribute("customers", customers);
        model.addAttribute("customer_spent", customerWithMostMoneySpent);
        model.addAttribute("customer_purchase", customerWithMostPurchases);
        model.addAttribute("total_customers", totalCustomers);

        return "customer/customers";
    }

    @GetMapping("/new")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("form_type", "new");

        return "customer/customerForm";
    }

    @PostMapping
    public ResponseEntity<String> saveCustomer(@Valid @ModelAttribute("customer") Customer customer) {
        try {
            return customerService.saveCustomer(customer);
        } catch (CustomerEmailAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Integer id) {
        try {
            return customerService.deleteCustomerById(id);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/edit")
    public String showEditCustomerForm(@PathVariable(value = "id") Integer id, Model model) {
        Customer customer = customerService.findCustomerById(id);

        model.addAttribute("form_type", "edit");
        model.addAttribute("customer", customer);

        return "customer/customerForm";
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable(value = "id") Integer id, @Valid @ModelAttribute("customer") Customer customer) {
        try {
            return customerService.updateCustomer(id, customer);
        } catch (CustomerEmailAlreadyExistsException | CustomerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
