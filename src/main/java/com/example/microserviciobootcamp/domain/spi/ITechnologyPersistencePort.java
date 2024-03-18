package com.example.microserviciobootcamp.domain.spi;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.example.microserviciobootcamp.domain.model.Technology;

import java.util.List;
import java.util.Optional;

public interface ITechnologyPersistencePort {
    Technology saveTechnology (Technology technology);
    Technology getTechnology(String name);
    Optional<Technology> findTechnologyByName (String name);
    List<Technology> getAllTechnologies(Integer page, Integer size, Boolean ascending);
}
