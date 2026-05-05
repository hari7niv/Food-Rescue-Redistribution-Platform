package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
    Recipient findByEmail(String email);
}
