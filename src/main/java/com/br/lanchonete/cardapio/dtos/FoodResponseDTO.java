package com.br.lanchonete.cardapio.dtos;
import com.br.lanchonete.cardapio.entity.Food;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;


public record FoodResponseDTO(UUID id, @NotBlank String title, @NotBlank String description, @NotBlank String image,
                              @NotNull BigDecimal price, @NotNull Integer quantity, @NotBlank String type) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getDescription(), food.getImage(),
                food.getPrice(), food.getQuantity() , food.getType());
    }
}
