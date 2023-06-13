package com.br.lanchonete.cardapio.repository;

import com.br.lanchonete.cardapio.entity.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoresRepository extends JpaRepository<Stores ,Long> {
}
