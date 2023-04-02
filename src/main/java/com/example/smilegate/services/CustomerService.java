package com.example.smilegate.services;

import com.example.smilegate.model.Customer;
import com.example.smilegate.repos.CustomerRepo;
import org.springframework.stereotype.Service;

/**
 * @author Tai Nguyen
 */
@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public void createCustomer(String name) {
        customerRepo.save(new Customer(name));
    }
}
