package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Food;
import com.example.demo.Repository.FoodRepository;

@Service
public class FoodService {
    private final FoodRepository repo;

    public FoodService(FoodRepository repo) {
        this.repo = repo;
    }

    public Food createFood(Food food) {
        return repo.save(food);
    }

    public List<Food> getAllFood() {
        return repo.findAll();
    }

    public Food getFoodById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Food not found"));
    }

    public List<Food> getFoodByName(String name) {
        return repo.findByName(name);
    }

    public String deleteFood(Long id){
        repo.deleteById(id);
        return "Food item deleted successfully";
    }


}
