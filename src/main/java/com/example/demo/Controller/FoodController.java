package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Food;
import com.example.demo.Service.FoodService;

@RestController
public class FoodController {
    private final FoodService service;
    public FoodController(FoodService service) {
        this.service = service;
    }
    @PostMapping("/food")
    public Food createFood(@RequestBody Food food){
        return service.createFood(food);
    }

    @GetMapping("/food")
    public List<Food> getAllFood(){
        return service.getAllFood();
    }

    @GetMapping("/food/search")
    public List<Food> getFoodByName(@RequestParam String name){
        return service.getFoodByName(name);
    }

}
