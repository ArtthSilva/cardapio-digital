package com.br.lanchonete.cardapio.repository;
import com.br.lanchonete.cardapio.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {

    List<Food> findByType(String type);
    @Query("SELECT DISTINCT f.type FROM foods f")
    List<String> findDistinctTypes();

}
