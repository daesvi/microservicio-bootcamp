package com.example.microserviciobootcamp.domain.api.usecase;

import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import com.example.microserviciobootcamp.domain.exception.TechnologyAlreadyExistsException;
import com.example.microserviciobootcamp.domain.model.Technology;
import com.example.microserviciobootcamp.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {

    private ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort){
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public Technology saveTechnology(Technology technology) {
        if (technologyPersistencePort.findTechnologyByName(technology.getName()).isPresent()){
            throw new TechnologyAlreadyExistsException(technology.getName());
        }
        return technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String name) {
        return technologyPersistencePort.getTechnology(name);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, Boolean ascending) {
        return technologyPersistencePort.getAllTechnologies(page, size, ascending);
    }
}
