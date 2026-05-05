package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Donors;

public interface DonorsRepository extends JpaRepository<Donors, Long>{
    Donors findByEmail(String email);
}
