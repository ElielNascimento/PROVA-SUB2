package com.cm.crud.models;

import com.cm.crud.controllers.AnimalEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animalName;
    private String animalType;
    private String animalBreed;
    private AnimalEnum animalEnum;


}
