package com.br.lanchonete.cardapio.dtos;
import com.br.lanchonete.cardapio.entity.Stores;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record StoresResponseDTO(UUID id, @NotBlank String name, @NotBlank String place, @NotBlank String contact) {
    public  StoresResponseDTO(Stores stores){
        this(stores.getId(), stores.getName(), stores.getContact(), stores.getPlace());
    }
}
