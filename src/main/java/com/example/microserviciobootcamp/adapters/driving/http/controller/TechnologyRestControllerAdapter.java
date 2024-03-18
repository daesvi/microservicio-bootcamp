package com.example.microserviciobootcamp.adapters.driving.http.controller;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.example.microserviciobootcamp.adapters.driving.http.dto.response.TechnologyResponse;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.example.microserviciobootcamp.adapters.driving.http.service.TechnologyHandlerImpl;
import com.example.microserviciobootcamp.configuration.exceptionhandler.ExceptionResponse;
import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {

    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyResponseMapper technologyResponseMapper;
    private final TechnologyHandlerImpl technologyHandler;

    @PostMapping("/")
    public ResponseEntity<TechnologyResponse> addTechnology(@RequestBody AddTechnologyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(technologyHandler.saveTechnology(request));
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologies (@RequestParam(defaultValue = "1") Integer page,
                                                                        @RequestParam(defaultValue = "10") Integer size,
                                                                        @RequestParam (required = false) Boolean ascending){
        return ResponseEntity.ok(technologyResponseMapper.toProductResponseList(technologyServicePort.getAllTechnologies(page, size, ascending)));
    }
}

