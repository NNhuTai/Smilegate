package com.example.smilegate.services;

import com.example.smilegate.model.Order;
import com.example.smilegate.repos.GameProductRepo;
import com.example.smilegate.repos.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Tai Nguyen
 */
public class OrderServiceTest {

    //@Spy
    private OrderService orderService;

    @BeforeEach
    void setMockOutput() {
        OrderRepo orderRepo = Mockito.mock(OrderRepo.class);
        GameProductRepo gameProductRepo = Mockito.mock(GameProductRepo.class);
        orderService = new OrderService(orderRepo, gameProductRepo);
        Order order = new Order();
        order.setName("test Order");
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));
    }
    @Test
    void testOderName() {
        assertEquals("test Order", orderService.getOderById(1L).getName());
    }

}
