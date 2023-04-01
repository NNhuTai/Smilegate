package com.example.smilegate.services;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.OderRequest;
import com.example.smilegate.model.Order;
import com.example.smilegate.repos.CustomerRepo;
import com.example.smilegate.repos.GameProductRepo;
import com.example.smilegate.repos.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Tai Nguyen
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private GameProductRepo gameProductRepo;

    @Transactional
    public void createOrder(OderRequest request){
        Set<GameProduct> gameProductList = new HashSet<>(gameProductRepo.findAllById(request.getGameIds()));

        if(gameProductList.size() > 0) {
            Order order = new Order();
            order.setCustomerId(request.getCustomerId());
            order.setName("Order " + request.getCustomerId());

            order.setListGame(gameProductList);
            AtomicReference<Long> total = new AtomicReference<>(0L);
            gameProductList.forEach(g-> total.updateAndGet(v -> v + g.getPrice()));
            order.setTotal(total.get());
            orderRepo.save(order);
        }
    }

    public void updateListGame(OderRequest request) {

        Order order = orderRepo.findById(request.getId()).orElse(null);
        if(order != null) {
            Set<GameProduct> gameProductSet = new HashSet<>(gameProductRepo.findAllById(request.getGameIds()));
            gameProductSet.addAll(order.getListGame());
            order.setListGame(gameProductSet);

            orderRepo.save(order);
        }
    }

    public Order getOderById(Long id){
        return orderRepo.findById(id).orElse(null);
    }

    public void addGame(OderRequest request) {
        Order order = orderRepo.findById(request.getId()).orElse(null);
        if(order != null) {
            Set<GameProduct> gameProductSet = new HashSet<>(gameProductRepo.findAllById(request.getGameIds()));
            gameProductSet.addAll(order.getListGame());
            order.setListGame(gameProductSet);
            AtomicReference<Long> total = new AtomicReference<>(0L);
            gameProductSet.forEach(g -> total.updateAndGet(v -> v + g.getPrice()));
            order.setTotal(total.get());

            orderRepo.save(order);
        }
    }

    public void pay(OderRequest request) {
        Order order = orderRepo.findById(request.getId()).orElse(null);
        if(order != null){
            order.setPay(true);
            orderRepo.save(order);
        }
    }

    public void deliver(OderRequest request) {
        Order order = orderRepo.findById(request.getId()).orElse(null);
        if(order != null) {
            order.setOrdered(true);
            orderRepo.save(order);
        }
    }
}
