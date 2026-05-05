package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{
    List<Food> findByName(String name);

    // List<Food> findByDonors(Long donorId);
}
