package com.example.smilegate.services;

import com.example.smilegate.model.Customer;
import com.example.smilegate.repos.CustomerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Tai Nguyen
 */
public class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setMockOutput() {
        CustomerRepo customerRepo = Mockito.mock(CustomerRepo.class);
        customerService = new CustomerService(customerRepo);
        Customer customer = new Customer();
        customer.setName("Smile");
        when(customerRepo.findById(1L)).thenReturn(Optional.of(customer));
    }
    @Test
    void testCustomerName(){
        assertEquals("Smile",customerService.getCustomer(1L).getName());
    }
}
