package com.example.microserviciobootcamp.adapters.driving.http.controller;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.example.microserviciobootcamp.adapters.driving.http.dto.response.TechnologyResponse;
import com.example.microserviciobootcamp.adapters.driving.http.service.TechnologyHandlerImpl;
import com.example.microserviciobootcamp.configuration.exceptionhandler.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final TechnologyHandlerImpl technologyHandler;

    @PostMapping("/")
    public ResponseEntity<ExceptionResponse> addTechnology(@RequestBody AddTechnologyRequest request) {
        technologyHandler.saveTechnology(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologies (@RequestParam(defaultValue = "0") Integer page,
                                                                        @RequestParam(defaultValue = "10") Integer size,
                                                                        @RequestParam (required = false) Optional<Boolean> ascending){
        return ResponseEntity.ok(technologyHandler.getAllTechnologies(page, size, ascending.orElse(false)));
    }
}

