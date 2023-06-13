package com.br.lanchonete.cardapio.controllers;
import com.br.lanchonete.cardapio.dtos.StoresRequestDTO;
import com.br.lanchonete.cardapio.dtos.StoresResponseDTO;

import com.br.lanchonete.cardapio.entity.Stores;
import com.br.lanchonete.cardapio.repository.StoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoresController {

    @Autowired
    StoresRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveStore(@RequestBody StoresRequestDTO data){
        Stores storeData = new Stores(data);
        repository.save(storeData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<StoresResponseDTO> getAll(){
        List<StoresResponseDTO> storesList = repository.findAll().stream().map(StoresResponseDTO::new).toList();
        return storesList;
    }

    @PutMapping
    @Transactional
    public void updateStore(@RequestBody StoresRequestDTO data){
        var store = repository.getReferenceById(data.id());
        store.updateStore(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removeStore(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
