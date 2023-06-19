package com.br.lanchonete.cardapio.controllers;
import com.br.lanchonete.cardapio.dtos.FoodResponseDTO;
import com.br.lanchonete.cardapio.entity.Food;
import com.br.lanchonete.cardapio.repository.FoodRepository;
import com.br.lanchonete.cardapio.services.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
 public class FoodController {
    @Autowired
    private FoodRepository repository;
    @Autowired
    private FoodService service;

     @PostMapping("/foods")
     public ResponseEntity<Food> postFood(@RequestBody @Valid FoodResponseDTO data){
        return service.saveFood(data);
     }

    @GetMapping("/foods")
    public ResponseEntity<List<Food>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/foods/{id}")
    public ResponseEntity <Object> getOneFood(@PathVariable(value ="id") UUID id){
         return service.getOneFood(id);
    }

    @PutMapping("/foods/{id}")
     public ResponseEntity<Object> updateFood(@PathVariable(value = "id")UUID id,
                                              @RequestBody @Valid FoodResponseDTO foodResponseDTO){
         return service.updateFood(id, foodResponseDTO);
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Object> deleteFood(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid FoodResponseDTO foodResponseDTO){
         return service.deleteFood(id, foodResponseDTO);
    }
}