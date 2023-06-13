package com.br.lanchonete.cardapio.entity;
import com.br.lanchonete.cardapio.dtos.StoresRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "stores")
@Entity(name = "stores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stores {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String place;

    private String contact;

    public Stores (StoresRequestDTO data){
        this.name = data.name();
        this.place = data.place();
        this.contact = data.contact();
    }

    public void updateStore(StoresRequestDTO data){
        if (data != null) {
            this.name = data.name();
        }
        if (data != null) {
            this.place = data.place();
        }
        if (data != null) {
            this.contact = data.contact();
        }
    }

}
