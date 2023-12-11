package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class FoodDTO {

    String foodName;
    BigDecimal weight;
    String foodDetails;
    BigDecimal price;
}
