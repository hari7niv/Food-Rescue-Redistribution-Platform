package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Food;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Recipient;
import com.example.demo.Repository.RecipientRepository;

@Service
public class RecipientService {
    
    private final RecipientRepository repo;
    private final OrderService orderService;
    private final FoodService foodService;
    public RecipientService(RecipientRepository repo, OrderService orderService, FoodService foodService){
        this.repo = repo;
        this.orderService = orderService;
        this.foodService = foodService;
    }

    public Recipient createRecipient(Recipient entity){
        return repo.save(entity);
    }

    public String recipientLogin(LoginDTO login){
        Recipient data = repo.findByEmail(login.getEmail());
        if(data == null){
            return "Recipient not found";
        }
        if(data.getPassword().equals(login.getPassword())){
            return "Login successful";
        }else{
            return "Invalid password";
        }
    }

    public String orderFood(Long recipientId, Long foodId){
        Recipient recipient = repo.findById(recipientId).orElseThrow(() -> new RuntimeException("Recipient not found"));
        Food food = foodService.getFoodById(foodId);
        Order order = new Order();
        order.setRecipient(recipient);
        order.setFood(food);
        orderService.createOrder(order);
        return "Order placed successfully";   
    }

    public String cancelOrder(Long orderId){
        orderService.deleteOrder(orderId);
        return "Order cancelled successfully";
    }

    
    

}
