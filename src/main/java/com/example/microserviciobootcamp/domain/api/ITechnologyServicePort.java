package com.example.microserviciobootcamp.domain.api;

import com.example.microserviciobootcamp.domain.model.Technology;

import java.util.List;
import java.util.Optional;

public interface ITechnologyServicePort {
    void saveTechnology (Technology technology);
    Technology getTechnology(String name);
    List<Technology> getAllTechnologies(Integer page, Integer size);
}
