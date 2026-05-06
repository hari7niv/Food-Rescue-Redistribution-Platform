package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order createOrder(Order order) {
        return repo.save(order);
    }
    
    public void deleteOrder(Long id) {
        repo.deleteById(id);
    }

    public Optional<Order> findById(Long id) {
        return repo.findById(id);
    }

    public List<Order> getOrder() {
        return repo.findAll();
    }

}
