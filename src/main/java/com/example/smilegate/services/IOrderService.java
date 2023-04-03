package com.example.smilegate.services;

import com.example.smilegate.model.OderRequest;
import com.example.smilegate.model.Order;

/**
 * @author Tai Nguyen
 */
public interface IOrderService {
    void createOrder(OderRequest request);
    void updateListGame(OderRequest request);
    Order getOderById(Long id);
    void addGame(OderRequest request);
    void pay(OderRequest request);
    void deliver(OderRequest request);
}
