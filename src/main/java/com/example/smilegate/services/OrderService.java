package com.example.smilegate.services;

import com.example.smilegate.model.GameProduct;
import com.example.smilegate.model.OderRequest;
import com.example.smilegate.model.Order;
import com.example.smilegate.repos.GameProductRepo;
import com.example.smilegate.repos.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Tai Nguyen
 */
@Service
@AllArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepo orderRepo;


    private final GameProductRepo gameProductRepo;


    @Transactional
    @Override
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

    @Override
    public void updateListGame(OderRequest request) {

        Order order = orderRepo.findById(request.getId()).orElse(null);
        if(order != null) {
            Set<GameProduct> gameProductSet = new HashSet<>(gameProductRepo.findAllById(request.getGameIds()));
            gameProductSet.addAll(order.getListGame());
            order.setListGame(gameProductSet);

            orderRepo.save(order);
        }
    }
    @Override
    public Order getOderById(Long id){
        return orderRepo.findById(id).orElse(null);
    }
    @Override
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
    @Override
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
