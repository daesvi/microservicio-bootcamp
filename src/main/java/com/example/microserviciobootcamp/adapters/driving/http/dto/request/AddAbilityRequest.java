package com.example.microserviciobootcamp.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AddAbilityRequest {
    private final String name;
    private final String description;
    private final List<Long> technologyIds;
}
