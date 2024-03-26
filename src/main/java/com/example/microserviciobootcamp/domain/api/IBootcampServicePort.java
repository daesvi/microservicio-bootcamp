package com.example.microserviciobootcamp.domain.api;

import com.example.microserviciobootcamp.domain.model.Bootcamp;

public interface IBootcampServicePort {
    Bootcamp saveBootcamp (Bootcamp bootcamp);
}
