package com.example.microserviciobootcamp.adapters.driving.http.controller;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddAbilityRequest;
import com.example.microserviciobootcamp.adapters.driving.http.dto.response.AbilityResponse;
import com.example.microserviciobootcamp.adapters.driving.http.service.handler_impl.AbilityHandlerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ability")
@RequiredArgsConstructor
public class AbilityRestControllerAdapter {
    private final AbilityHandlerImpl abilityHandler;

    @PostMapping("/")
    public ResponseEntity<AbilityResponse> addAbility(@RequestBody AddAbilityRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abilityHandler.saveAbility(request));
    }
}
