package com.br.lanchonete.cardapio.dtos;

public record FoodRequestDTO(Long id, String title, String description, String image, Integer price, Integer quantity) {
}
