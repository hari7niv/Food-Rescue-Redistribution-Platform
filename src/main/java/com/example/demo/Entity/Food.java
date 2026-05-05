package com.example.demo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Food {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long FoodId;

    private String name;

    private Integer quantity;

    private Integer ValidHours;

    @ManyToOne
    @JoinColumn(name = "DonorsId")
    private Donors donors;

}
