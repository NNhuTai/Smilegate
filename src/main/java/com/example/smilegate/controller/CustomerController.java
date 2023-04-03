package com.example.smilegate.controller;

import com.example.smilegate.model.Customer;
import com.example.smilegate.services.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @author Tai Nguyen
 */
@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/get/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
    @PostMapping("/create/{name}")
    public void createCustomer(@PathVariable String name) {
        customerService.createCustomer(name);
    }
}
