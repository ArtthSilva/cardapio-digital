package com.br.lanchonete.cardapio.controllers;

import com.br.lanchonete.cardapio.dtos.FoodRequestDTO;
import com.br.lanchonete.cardapio.dtos.FoodResponseDTO;
import com.br.lanchonete.cardapio.entity.Food;
import com.br.lanchonete.cardapio.repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PutMapping
    @Transactional
    public void updateFood(@RequestBody FoodRequestDTO data){
        var food = repository.getReferenceById(data.id());
        food.updateFood(data);
    }

    @DeleteMapping("/{id}")
     @Transactional
    public void removeFood(@PathVariable Long id) {
        repository.deleteById(id);
    }


}