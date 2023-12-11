package com.example.demo.controller;

import com.example.demo.dto.FoodDTO;
import com.example.demo.entity.FoodEntity;
import com.example.demo.repository.FoodRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodControllerImpl implements FoodController {

    private final FoodRepository foodRepository;

    @GetMapping("/all")
    public ResponseEntity<List<FoodEntity>> getAllFoods() {
        List<FoodEntity> foodList = foodRepository.findAll();

        // Check if the list is not empty
        if (!foodList.isEmpty()) {
            // If there is data, return it with HttpStatus.OK
            ResponseEntity<List<FoodEntity>> response = new ResponseEntity<>(foodList, HttpStatus.OK);
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        } else {
            // If the list is empty, you can return HttpStatus.NO_CONTENT or HttpStatus.NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/update")
    @Override
    public List<FoodEntity> updateFoodPriceById(@RequestParam("price") BigDecimal price, @RequestParam("id") Long id) {
        foodRepository.updateFoodPriceById(price, id);
        return foodRepository.findAll();
    }

    @PutMapping("/save")
    @Override
    public FoodEntity saveFood(@RequestBody FoodDTO dto) {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setFoodDetails(dto.getFoodDetails());
        foodEntity.setFoodName(dto.getFoodName());
        foodEntity.setWeight(dto.getWeight());
        foodEntity.setPrice(dto.getPrice());
        return foodRepository.save(foodEntity);
    }


    @DeleteMapping("/delete")
    @Override
    public List<FoodEntity> deleteFood(@RequestParam("id") Long id) {
        foodRepository.deleteFoodById(id);
        return foodRepository.findAll();
    }
}
