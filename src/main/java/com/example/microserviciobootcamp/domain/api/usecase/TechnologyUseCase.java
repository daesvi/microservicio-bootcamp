package com.example.microserviciobootcamp.domain.api.usecase;

import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import com.example.microserviciobootcamp.domain.exception.EmptyFieldException;
import com.example.microserviciobootcamp.domain.exception.FieldExceedsCharactersException;
import com.example.microserviciobootcamp.domain.exception.TechnologyAlreadyExistsException;
import com.example.microserviciobootcamp.domain.model.Technology;
import com.example.microserviciobootcamp.domain.spi.ITechnologyPersistencePort;
import com.example.microserviciobootcamp.domain.util.DomainConstants;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {

    private ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort){
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology) {
        String nameTechnology = technology.getName();
        String descriptionTechnology = technology.getDescription();
        if (technologyPersistencePort.findTechnologyByName(technology.getName()).isPresent()){
            throw new TechnologyAlreadyExistsException(technology.getName());
        }
        if (nameTechnology.isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }else if (nameTechnology.length()>50){
            throw new FieldExceedsCharactersException(DomainConstants.Field.NAME.toString());
        }
        if (descriptionTechnology.isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        } else if (descriptionTechnology.length()>90){
            throw new FieldExceedsCharactersException(DomainConstants.Field.DESCRIPTION.toString());
        }
        technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String name) {
        return technologyPersistencePort.getTechnology(name);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size) {
        return technologyPersistencePort.getAllTechnologies(page, size);
    }
}
