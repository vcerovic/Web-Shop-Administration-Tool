package com.veljko.webshop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String listAllCustomers(Model model){
        List<Customer> customers = customerService.findAll();
        Customer customerWithMostMoneySpent = customerService.findCustomerWithMostMoneySpent();
        Customer customerWithMostPurchases = customerService.findCustomerWithMostPurchases();
        long totalCustomers = customerService.countAll();
        System.out.println(totalCustomers);

        model.addAttribute("customers", customers);
        model.addAttribute("customer_spent", customerWithMostMoneySpent);
        model.addAttribute("customer_purchase", customerWithMostPurchases);
        model.addAttribute("total_customers", totalCustomers);

        return "customer/customers";
    }

    @GetMapping("/new")
    public String showAddCustomerForm(){
        return "customer/newCustomerForm";
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
