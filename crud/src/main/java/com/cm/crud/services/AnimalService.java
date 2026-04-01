package com.cm.crud.services;

import com.cm.crud.models.AnimalModel;
import com.cm.crud.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class AnimalService {

     @Autowired
     private AnimalRepository animalRepository;

     public List<AnimalModel> findAll(){
         return  animalRepository.findAll();
     }


     public AnimalModel criarAnimal(@RequestBody AnimalModel animalModel){
         return  animalRepository.save(animalModel);
     }
     public  AnimalModel atualizarAnimal(@RequestBody AnimalModel animalModel, @PathVariable Long id){
          AnimalModel response = animalRepository.findById(id).get();
          response.setAnimalName(animalModel.getAnimalName());
          response.setAnimalType(animalModel.getAnimalType());
          return animalRepository.save(response);
     }

     public void deletarAnimal(@PathVariable Long id){
         animalRepository.deleteById(id);
     }

     public AnimalModel findById(@PathVariable Long id){
         return animalRepository.findById(id).get();
     }

}
