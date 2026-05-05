package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.VolunteerOrderDTO;
import com.example.demo.Entity.Volunteers;
import com.example.demo.Service.VolunteersService;

@RestController
public class VolunteersControllers {
    
    private final VolunteersService service;
    public VolunteersControllers(VolunteersService service){
        this.service = service;
    }

    @PostMapping("/Volunteers")
    public Volunteers createVolunteer(@RequestBody Volunteers volunteer){
        return service.createVolunteer(volunteer);
    }

    @PostMapping("/Volunteers/login")
    public String volunteerLogin(@RequestBody LoginDTO login){
        return service.volunteerLogin(login);
    }

    @PostMapping("/Volunteers/accept-order")
    public String acceptOrder(@RequestBody VolunteerOrderDTO volunteerOrder){
        return service.acceptOrder(volunteerOrder.getVolunteerId(), volunteerOrder.getOrderId());
    }

}
