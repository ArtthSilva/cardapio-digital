package com.br.lanchonete.cardapio.repository;

import com.br.lanchonete.cardapio.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
