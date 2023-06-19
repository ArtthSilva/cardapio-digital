package com.br.lanchonete.cardapio.services;
import com.br.lanchonete.cardapio.dtos.StoresResponseDTO;
import com.br.lanchonete.cardapio.entity.Stores;
import com.br.lanchonete.cardapio.repository.StoresRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoresService {
    @Autowired
    public StoresRepository repository;
    public ResponseEntity<Stores> saveStore(@RequestBody @Valid StoresResponseDTO data){
        var storeModel = new Stores();
        BeanUtils.copyProperties(data, storeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(storeModel));
    }

    public ResponseEntity<Object> getOneStore(@PathVariable(value ="id") UUID id){
        Optional<Stores> optionalStore = repository.findById(id);
        if (optionalStore.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("store not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalStore.get());
    }

    public ResponseEntity<Object> updateStore(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid StoresResponseDTO storeResponseDTO){
       Optional<Stores> storeOptional = repository.findById(id);
        if (storeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("store not found");
        }
        var storeModel = storeOptional.get();
        BeanUtils.copyProperties(storeResponseDTO, storeModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(storeModel));
    }

    public ResponseEntity<Object> deleteStore(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid StoresResponseDTO storeResponseDTO){
        Optional<Stores> optionalStore = repository.findById(id);
        if (optionalStore.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("store not found");
        }
        repository.delete(optionalStore.get());
        return ResponseEntity.status(HttpStatus.OK).body("Store deleted successfully");
    }
}
