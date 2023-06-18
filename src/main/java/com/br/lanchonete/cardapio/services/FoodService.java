package com.br.lanchonete.cardapio.services;

import com.br.lanchonete.cardapio.dtos.FoodResponseDTO;
import com.br.lanchonete.cardapio.entity.Food;
import com.br.lanchonete.cardapio.repository.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService {
    @Autowired
    public FoodRepository repository;
     public ResponseEntity<Food> saveFood(@RequestBody @Valid FoodResponseDTO data){
        var foodModel = new Food();
        BeanUtils.copyProperties(data, foodModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(foodModel));
    }

    public ResponseEntity<Object> getOneFood(@PathVariable(value ="id") UUID id){
        Optional<Food> optionalFood = repository.findById(id);
        if (optionalFood.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("food not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalFood.get());
    }

    public ResponseEntity<Object> updateFood(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid FoodResponseDTO foodResponseDTO){
        Optional<Food> foodOptional = repository.findById(id);
        if (foodOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("food not found");
        }
        var foodModel = foodOptional.get();
        BeanUtils.copyProperties(foodResponseDTO, foodModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(foodModel));
    }

    public ResponseEntity<Object> deleteFood(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid FoodResponseDTO foodResponseDTO){
        Optional<Food> foodOptional = repository.findById(id);
        if (foodOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("food not found");
        }
        repository.delete(foodOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Food deleted successfully");
    }
}
