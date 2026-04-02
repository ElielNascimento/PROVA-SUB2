package com.cm.crud.services;

import com.cm.crud.models.AnimalModel;
import com.cm.crud.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/animais")
public class AnimalController {


    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping
    public ResponseEntity <AnimalModel> criarAnimal(@RequestBody AnimalModel animalModel){
       AnimalModel requeste = animalRepository.save(animalModel);
       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("{/id}")
               .buildAndExpand(requeste.getId())
               .toUri();
       return ResponseEntity.created(uri).body(requeste);
    }
    @GetMapping
    public ResponseEntity<List<AnimalModel>> findAll(){
        List<AnimalModel> requeste = animalRepository.findAll();
        return ResponseEntity.ok().body(requeste);
    }
    @DeleteMapping
    public ResponseEntity<?> deletarAnimal(@PathVariable Long id){
        animalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<AnimalModel> atualizarAnimal(@PathVariable Long id, @RequestBody AnimalModel animalModel){
        AnimalModel novoAnimal = animalRepository.findById(id).get();
        return ResponseEntity.ok().body(novoAnimal);
    }

    @GetMapping
    public ResponseEntity<AnimalModel> findById(@PathVariable Long id){
      AnimalModel request = animalRepository.findById(id).get();
       return  ResponseEntity.ok().body(request);
    }


}
