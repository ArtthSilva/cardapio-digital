package com.br.lanchonete.cardapio.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record FoodRequestDTO(UUID id, String title, String description, String image, BigDecimal price, Integer quantity) {
}
