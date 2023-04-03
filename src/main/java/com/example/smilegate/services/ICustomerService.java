package com.example.smilegate.services;

import com.example.smilegate.model.Customer;

/**
 * @author Tai Nguyen
 */
public interface ICustomerService {
    Customer getCustomer(Long id);
    void createCustomer(String name);
}
