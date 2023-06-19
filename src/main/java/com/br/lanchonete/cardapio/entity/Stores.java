package com.br.lanchonete.cardapio.entity;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "stores")
@Entity(name = "stores")
public class Stores implements Serializable {
    @Serial
    private static final long serialVersionUID  = 1L;

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String place;

    private String contact;

//    public Stores (StoresRequestDTO data){
//        this.name = data.name();
//        this.place = data.place();
//        this.contact = data.contact();
//    }
//
//    public void updateStore(StoresRequestDTO data){
//        if (data != null) {
//            this.name = data.name();
//        }
//        if (data != null) {
//            this.place = data.place();
//        }
//        if (data != null) {
//            this.contact = data.contact();
//        }
//    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getContact() {
        return contact;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Stores() {
    }

}
