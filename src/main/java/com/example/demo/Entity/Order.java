package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`order`")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long OrderId;

    @OneToOne
    @JoinColumn(name = "RecipientId")
    private Recipient recipient;

    @OneToOne
    @JoinColumn(name = "FoodId")
    private Food food;

    @OneToOne
    @JoinColumn(name = "VolunteersId")
    private Volunteers volunteers;
}
