package com.example.demo.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity(name = "restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurantIdSeqGenerator")
    @SequenceGenerator(name = "restaurantIdSeqGenerator", sequenceName = "restaurant_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "restaurant_name", unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<MenuEntity> menus;

    @Column
    private boolean isOpen;

    @Timestamp
    @Column
    Instant openFrom;
}
