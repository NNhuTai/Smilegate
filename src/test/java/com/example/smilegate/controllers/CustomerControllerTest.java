package com.example.smilegate.controllers;

import com.example.smilegate.controller.CustomerController;
import com.example.smilegate.model.Customer;
import com.example.smilegate.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Tai Nguyen
 */
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setMockOutput()
    {
        when(customerService.getCustomer(1L)).thenReturn(new Customer("SMILE"));
    }
    @Test
    void testCustomerName(){
        assertEquals("SMILE", customerController.getCustomer(1L).getName());
    }
}
