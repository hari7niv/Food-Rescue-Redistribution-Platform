package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Donors;
import com.example.demo.Repository.DonorsRepository;

@Service
public class DonarService {
    
    private final DonorsRepository repo;
    public DonarService(DonorsRepository repo) {
        this.repo = repo;
    }

    public Donors createDonar(Donors donor){
        return repo.save(donor);
    }

    public String donorLogin(LoginDTO login){
        Donors donor = repo.findByEmail(login.getEmail());
        if(donor == null){
            return "Donor not found";
        }
        if(donor.getPassword().equals(login.getPassword())){
            return "Login successful";
        }else{
            return "Invalid password";
        }
    }
}
