package com.example.microserviciobootcamp.adapters.driving.http.service;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;

public interface ITechnologyHandler {
    void saveTechnology(AddTechnologyRequest request);
}
