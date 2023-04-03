package com.example.smilegate.controller;

import com.example.smilegate.model.OderRequest;
import com.example.smilegate.model.Order;
import com.example.smilegate.services.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tai Nguyen
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OderController {
    private final IOrderService orderService;
    @PostMapping("/create")
    public void createOder(@RequestBody OderRequest oderRequest){
        orderService.createOrder(oderRequest);
    }

    @PutMapping("/update")
    public void updateGame(@RequestBody OderRequest request) {
        orderService.updateListGame(request);
    }

    @PutMapping("/addGame")
    public void addGame(@RequestBody OderRequest request) {
        orderService.addGame(request);
    }

    @PutMapping("/pay")
    public void pay(@RequestBody OderRequest request) {
        orderService.pay(request);
    }

    @PutMapping("/deliver")
    public void deliver(@RequestBody OderRequest request) {
        orderService.deliver(request);
    }

    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOderById(id);
    }
}
