package com.br.lanchonete.cardapio.dtos;
import com.br.lanchonete.cardapio.entity.Food;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;



public record FoodResponseDTO(@NotBlank String title, @NotBlank String description, @NotBlank String image,
                              @NotNull BigDecimal price, @NotNull Integer quantity) {
    public FoodResponseDTO(Food food){
        this( food.getTitle(), food.getDescription(), food.getImage(), food.getPrice(), food.getQuantity());
    }
}
