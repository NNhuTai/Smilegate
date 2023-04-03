package com.example.smilegate.services;

import com.example.smilegate.model.Customer;
import com.example.smilegate.repos.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Tai Nguyen
 */
@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).orElse(null);
    }
    @Override
    public void createCustomer(String name) {
        customerRepo.save(new Customer(name));
    }
}
