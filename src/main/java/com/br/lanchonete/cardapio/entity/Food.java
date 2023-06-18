package com.br.lanchonete.cardapio.entity;


import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "foods")
@Entity(name = "foods")
public class Food implements Serializable {
    @Serial
    private static final long serialVersionUID  = 1L;

@Id@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

     private String title;

     private String description;

    private String image;

     private BigDecimal price;

     private Integer quantity;

//    public Food(FoodRequestDTO data){
//        this.title = data.title();
//        this.description = data.description();
//        this.image = data.image();
//        this.price = data.price();
//        this.quantity = data.quantity();
//    }

//    public void updateFood(FoodRequestDTO data){
//        if (data != null){
//            this.title = data.title();
//        }
//        if (data != null){
//            this.description = data.description();
//        }
//        if (data != null){
//            this.image = data.image();
//        }
//        if (data != null){
//            this.price = data.price();
//        }
//        if (data!= null) {
//            this.quantity = data.quantity();
//        }
//    }


    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Food() {
    }

}
