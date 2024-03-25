package com.example.microserviciobootcamp.domain.api;

import com.example.microserviciobootcamp.domain.model.Ability;

public interface IAbilityServicePort {
    Ability saveAbility (Ability ability);
}
