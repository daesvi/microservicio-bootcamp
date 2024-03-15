package com.example.microserviciobootcamp.domain.model;

import com.example.microserviciobootcamp.domain.exception.EmptyFieldException;
import com.example.microserviciobootcamp.domain.exception.FieldExceedsCharactersException;
import com.example.microserviciobootcamp.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Technology {
    private final Long id;
    private final String name;
    private final String description;

    public Technology(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {return id;}

    public String getName() {return name;}

    public String getDescription() {return description;}
}
