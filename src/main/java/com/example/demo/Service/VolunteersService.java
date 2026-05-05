package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.Volunteers;
import com.example.demo.Repository.VolunteersRepository;

@Service
public class VolunteersService {
    
    private final VolunteersRepository repo;
    private final OrderService orderService;
    public VolunteersService(VolunteersRepository repo, OrderService orderService){ 
        this.repo = repo;   
        this.orderService = orderService;
    }

    public Volunteers createVolunteer(Volunteers volunteer){
        return repo.save(volunteer);
    }
    
    public String volunteerLogin(LoginDTO login){
        Volunteers volunteer = repo.findByEmail(login.getEmail());
        if(volunteer == null){
            return "Volunteer not found";
        }
        if(volunteer.getPassword().equals(login.getPassword())){
            return "Login successful";
        }else{
            return "Invalid password";
        }
    }

    public String acceptOrder(Long volunteerId, Long orderId){
        Order order = orderService.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        Volunteers volunteer = repo.findById(volunteerId).orElseThrow(() -> new RuntimeException("Volunteer not found"));
        order.setVolunteers(volunteer);
        orderService.createOrder(order);
        return "Order accepted successfully";
    }

    
}
