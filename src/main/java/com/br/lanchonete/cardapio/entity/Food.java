package com.br.lanchonete.cardapio.entity;

import com.br.lanchonete.cardapio.dtos.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    private static final long serialVersionUID  = 1L;

@Id@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

     private String title;

     private String description;

    private String image;

     private BigDecimal price;

     private Integer quantity;

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.description = data.description();
        this.image = data.image();
        this.price = data.price();
        this.quantity = data.quantity();
    }

    public void updateFood(FoodRequestDTO data){
        if (data != null){
            this.title = data.title();
        }
        if (data != null){
            this.description = data.description();
        }
        if (data != null){
            this.image = data.image();
        }
        if (data != null){
            this.price = data.price();
        }
        if (data!= null) {
            this.quantity = data.quantity();
        }
    }
}
