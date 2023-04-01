package com.example.smilegate.controller;

import com.example.smilegate.model.Customer;
import com.example.smilegate.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Tai Nguyen
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
    @PostMapping("/create")
    public void createCustomer(@PathVariable String name) {
        customerService.createCustomer(name);
    }
}
