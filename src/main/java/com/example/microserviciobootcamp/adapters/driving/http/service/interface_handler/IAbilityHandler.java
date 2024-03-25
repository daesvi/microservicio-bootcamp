package com.example.microserviciobootcamp.adapters.driving.http.service.interface_handler;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddAbilityRequest;
import com.example.microserviciobootcamp.adapters.driving.http.dto.response.AbilityResponse;

import java.util.List;

public interface IAbilityHandler {
    AbilityResponse saveAbility(AddAbilityRequest request);
}
