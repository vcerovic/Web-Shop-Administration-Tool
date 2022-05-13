package com.veljko.webshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void listAllCustomers(){
        List<Customer> customers = customerService.findAll();

        for(Customer customer : customers){
            System.out.println(customer.toString());
        }
    }

    @GetMapping("/new")
    public void showAddCustomerForm(){
        System.out.println("show new form");
    }

    @PostMapping
    public void saveCustomer(@ModelAttribute("customer") Customer customer){
        System.out.println(customer.toString());
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Integer id){
        System.out.println(id);
    }

    @GetMapping("/{id}/edit")
    public void showEditCustomerForm(@PathVariable(value = "id") Integer id){
        System.out.println("show edit form");
    }

    @PutMapping("/{id}")
    public void updateCustomer(@ModelAttribute("customer") Customer customer){
        System.out.println(customer);
    }




}
