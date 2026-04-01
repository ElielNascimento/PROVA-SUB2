package com.cm.crud.Controller;

import com.cm.crud.models.AnimalModel;
import com.cm.crud.services.AnimalService;
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
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalModel> criarAnimal(@RequestBody AnimalModel animalModel){
       AnimalModel requeste = animalService.criarAnimal(animalModel);
       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("{/id}")
               .buildAndExpand(requeste.getId())
               .toUri();
       return ResponseEntity.created(uri).body(requeste);
    }
    @GetMapping
    public ResponseEntity<List<AnimalModel>> findAll(){
        List<AnimalModel> requeste = animalService.findAll();
        return ResponseEntity.ok().body(requeste);
    }
    @DeleteMapping
    public ResponseEntity<?> deletarAnimal(@PathVariable Long id){
        animalService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<AnimalModel> atualizarAnimal(@PathVariable Long id, @RequestBody AnimalModel animalModel){
        AnimalModel novoAnimal = animalService.atualizarAnimal(animalModel, id);
        return ResponseEntity.ok().body(novoAnimal);
    }

    @GetMapping
    public ResponseEntity<AnimalModel> findById(@PathVariable Long id){
        AnimalModel requeste = animalService.findById(id);
        return ResponseEntity.ok().body(requeste);
    }


}
