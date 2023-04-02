package com.example.smilegate.controllers;

import com.example.smilegate.controller.OderController;
import com.example.smilegate.model.Order;
import com.example.smilegate.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Tai Nguyen
 */
public class OderControllerTest {

    private OderController oderController;

    @BeforeEach
    void setMockOutput()
    {
        OrderService orderService = Mockito.mock(OrderService.class);
        oderController = new OderController(orderService);
        Order order = new Order();
        order.setName("test Order");
        when(orderService.getOderById(1L)).thenReturn(order);
    }
    @Test
    void testOrderName()
    {
        assertEquals("test Order", oderController.getOrder(1L).getName());
    }
}
