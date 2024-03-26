package com.example.microserviciobootcamp.domain.spi;

import com.example.microserviciobootcamp.domain.model.Bootcamp;

public interface IBootcampPersistencePort {
    Bootcamp saveBootcamp (Bootcamp bootcamp);
}
