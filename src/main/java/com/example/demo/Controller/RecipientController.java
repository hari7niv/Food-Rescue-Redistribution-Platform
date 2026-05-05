package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.OrderFood;
import com.example.demo.Entity.Recipient;
import com.example.demo.Service.RecipientService;

@RestController
public class RecipientController {
    private final RecipientService service;
    public RecipientController(RecipientService service){
        this.service = service;
    }

    @PostMapping("/recipient")
    public Recipient createRecipient(@RequestBody Recipient entity){
       return service.createRecipient(entity);
    }

    @PostMapping("/recipient/login")
    public String recipientLogin(@RequestBody LoginDTO login){
        return service.recipientLogin(login);
    }

    @PostMapping("/recipient/order")
    public String orderFood(@RequestBody OrderFood orderFood){
        return service.orderFood(orderFood.getRecipientId(), orderFood.getFoodId());
    }
    
    
}
