package com.br.lanchonete.cardapio.dtos;

import com.br.lanchonete.cardapio.entity.Food;

public record FoodResponseDTO(Long id, String title, String description, String image, Integer price) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getDecription(), food.getImage(), food.getPrice());
    }
}
