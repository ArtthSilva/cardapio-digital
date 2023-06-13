package com.br.lanchonete.cardapio.entity;

import com.br.lanchonete.cardapio.dtos.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private String title;

     private String description;

    private String image;

     private Integer price;

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
