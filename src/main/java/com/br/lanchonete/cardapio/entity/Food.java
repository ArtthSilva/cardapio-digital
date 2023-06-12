package com.br.lanchonete.cardapio.entity;

import com.br.lanchonete.cardapio.dtos.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "food")
@Entity(name = "food")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String decription;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.decription = data.description();
        this.image = data.image();
        this.price = data.price();
    }
}
