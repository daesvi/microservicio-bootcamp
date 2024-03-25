package com.example.microserviciobootcamp.adapters.driven.jpa.mysql.adapter;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.AbilityEntity;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.mapper.IAbilityEntityMapper;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository.IAbilityRepository;
import com.example.microserviciobootcamp.domain.model.Ability;
import com.example.microserviciobootcamp.domain.spi.IAbilityPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AbilityAdapter implements IAbilityPersistencePort {
    private final IAbilityRepository abilityRepository;
    private final IAbilityEntityMapper abilityEntityMapper;
    @Override
    public Ability saveAbility(Ability ability) {
        AbilityEntity abilityEntity = abilityEntityMapper.toEntity(ability);
        AbilityEntity savedAbility = abilityRepository.save(abilityEntity);
        return abilityEntityMapper.toModel(savedAbility);
    }

    @Override
    public Optional<Ability> findAbilityByName(String name) {
        return abilityRepository.findByName(name).map(abilityEntityMapper::toModel);
    }
}
