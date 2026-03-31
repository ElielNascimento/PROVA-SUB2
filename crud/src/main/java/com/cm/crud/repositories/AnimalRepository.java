package com.cm.crud.repositories;

import com.cm.crud.models.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
}
