package com.example.microserviciobootcamp.adapters.driven.jpa.mysql.adapter;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.mapper.IBootcampEntityMapper;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.example.microserviciobootcamp.domain.model.Bootcamp;
import com.example.microserviciobootcamp.domain.spi.IBootcampPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BootcampAdapter implements IBootcampPersistencePort {
    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;
    @Override
    public Bootcamp saveBootcamp(Bootcamp bootcamp) {
        BootcampEntity bootcampEntity = bootcampEntityMapper.toEntity(bootcamp);
        BootcampEntity bootcampSaved = bootcampRepository.save(bootcampEntity);
        return bootcampEntityMapper.toModel(bootcampSaved);
    }
}
