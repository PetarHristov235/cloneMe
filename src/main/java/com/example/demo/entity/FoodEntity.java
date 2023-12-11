package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "food")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurantIdSeqGenerator")
    @SequenceGenerator(name = "restaurantIdSeqGenerator", sequenceName = "food_id_seq", allocationSize = 1)
    Long id;

    @Column(name = "food_name")
    String foodName;

    @Column(name = "weight")
    BigDecimal weight;

    @Column(name = "food_details")
    String foodDetails;

    @Column(name = "price")
    BigDecimal price;
}
