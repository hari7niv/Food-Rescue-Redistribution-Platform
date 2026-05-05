package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Volunteers;

public interface VolunteersRepository extends JpaRepository<Volunteers, Long>{
    Volunteers findByEmail(String email);
}
