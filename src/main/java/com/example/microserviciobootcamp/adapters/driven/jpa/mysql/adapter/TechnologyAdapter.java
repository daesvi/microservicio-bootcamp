package com.example.microserviciobootcamp.adapters.driven.jpa.mysql.adapter;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.example.microserviciobootcamp.domain.exception.TechnologyAlreadyExistsException;
import com.example.microserviciobootcamp.domain.model.Technology;
import com.example.microserviciobootcamp.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public void saveTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()){
            throw new TechnologyAlreadyExistsException(technology.getName());
        }
        TechnologyEntity technologyEntity = technologyEntityMapper.toEntity(technology);
        technologyRepository.save(technologyEntity);
    }

    @Override
    public Technology getTechnology(String name) {
        return null;
    }

    @Override
    public Optional<Technology> findTechnologyByName(String name) {
        return technologyRepository.findByName(name).map(technologyEntityMapper::toModel);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size, Boolean ascending) {
        return null;
    }
}
