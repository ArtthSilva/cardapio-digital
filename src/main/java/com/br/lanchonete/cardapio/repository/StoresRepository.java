package com.br.lanchonete.cardapio.repository;
import com.br.lanchonete.cardapio.entity.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface StoresRepository extends JpaRepository<Stores, UUID> {
}
