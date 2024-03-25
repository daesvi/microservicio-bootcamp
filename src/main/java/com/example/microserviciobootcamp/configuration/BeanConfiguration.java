package com.example.microserviciobootcamp.configuration;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.adapter.AbilityAdapter;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.mapper.IAbilityEntityMapper;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository.IAbilityRepository;
import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.example.microserviciobootcamp.domain.api.IAbilityServicePort;
import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import com.example.microserviciobootcamp.domain.api.usecase.AbilityUseCase;
import com.example.microserviciobootcamp.domain.api.usecase.TechnologyUseCase;
import com.example.microserviciobootcamp.domain.spi.IAbilityPersistencePort;
import com.example.microserviciobootcamp.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;
    private final IAbilityEntityMapper abilityEntityMapper;
    private final IAbilityRepository abilityRepository;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort(){
        return new TechnologyAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public IAbilityPersistencePort abilityPersistencePort(){
        return new AbilityAdapter(abilityRepository, abilityEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort(){
        return new TechnologyUseCase(technologyPersistencePort());
    }

    @Bean
    public IAbilityServicePort abilityServicePort(){
        return new AbilityUseCase(abilityPersistencePort(), technologyPersistencePort());
    }
}
