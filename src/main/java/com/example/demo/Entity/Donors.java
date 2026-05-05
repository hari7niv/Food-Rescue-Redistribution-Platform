package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Donors {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long DonorsId;

    private String name;
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    private String address;

    private String password;
    
}
