package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Donors;
import com.example.demo.Service.DonarService;

@RestController
public class DonorsController {
    private final DonarService service;

    public DonorsController(DonarService service) {
        this.service = service;
    }

    @PostMapping("/donors")
    public Donors createDonar(@RequestBody Donors donor){
        return service.createDonar(donor);
    }

    @PostMapping("/donors/login")
    public String donorLogin(@RequestBody LoginDTO login){
        return service.donorLogin(login);
    }
}
