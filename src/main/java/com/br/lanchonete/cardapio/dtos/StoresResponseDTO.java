package com.br.lanchonete.cardapio.dtos;

import com.br.lanchonete.cardapio.entity.Stores;

public record StoresResponseDTO(Long id, String name, String place, String contact) {
    public  StoresResponseDTO(Stores stores){
        this(stores.getId(), stores.getName(), stores.getContact(), stores.getPlace());
    }
}
