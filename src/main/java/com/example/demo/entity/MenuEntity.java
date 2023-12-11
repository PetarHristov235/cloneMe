package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@Entity(name = "menu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuIdSeqGenerator")
    @SequenceGenerator(name = "menuIdSeqGenerator", sequenceName = "menu_id_seq", allocationSize = 1)
    Long id;

    @OneToMany
    @JoinColumn(name = "menu_id")
    List<FoodEntity> food;

    @CreatedDate
    Instant createdOn;
}
