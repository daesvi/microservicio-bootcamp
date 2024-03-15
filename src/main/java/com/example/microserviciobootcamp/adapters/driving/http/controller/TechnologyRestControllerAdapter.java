package com.example.microserviciobootcamp.adapters.driving.http.controller;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.example.microserviciobootcamp.adapters.driving.http.service.TechnologyHandlerImpl;
import com.example.microserviciobootcamp.configuration.exceptionhandler.ExceptionResponse;
import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;
    private final TechnologyHandlerImpl technologyHandler;

    @PostMapping("/")
    public ResponseEntity<ExceptionResponse> addTechnology(@RequestBody AddTechnologyRequest request) {
        technologyHandler.saveTechnology(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

