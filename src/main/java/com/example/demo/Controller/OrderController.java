package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;

@RestController
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) {
        this.service = service;
    }
    
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order){
       return service.createOrder(order); 
    }
    @DeleteMapping("/orders/{id}")
    public String cancelOrder(@PathVariable Long id){
       service.deleteOrder(id);
       return "Order cancelled successfully";
    }
    
    @GetMapping("/orders")
    public List<Order> getOrder(){
       return service.getOrder();
    }
}
