package com.br.lanchonete.cardapio.dtos;

import java.util.UUID;

public record StoresRequestDTO(UUID id, String name, String place, String contact) {
}
