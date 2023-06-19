package com.br.lanchonete.cardapio.controllers;
import com.br.lanchonete.cardapio.dtos.StoresResponseDTO;
import com.br.lanchonete.cardapio.entity.Stores;
import com.br.lanchonete.cardapio.repository.StoresRepository;
import com.br.lanchonete.cardapio.services.StoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class StoresController {

    @Autowired
    private StoresRepository repository;
    @Autowired
    private StoresService service;

    @PostMapping("/stores")
    public ResponseEntity<Stores> postStores(@RequestBody @Valid StoresResponseDTO data){
        return service.saveStore(data);
    }

    @GetMapping("/stores")
    public ResponseEntity<List<Stores>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/stores/{id}")
    public ResponseEntity <Object> getOneStore(@PathVariable(value ="id") UUID id){
        return service.getOneStore(id);
    }

    @PutMapping("/stores/{id}")
    public ResponseEntity<Object> updateStore(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid StoresResponseDTO storeResponseDTO){
        return service.updateStore(id, storeResponseDTO);
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<Object> deleteStore(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid StoresResponseDTO storeResponseDTO){
        return service.deleteStore(id, storeResponseDTO);
    }
}
