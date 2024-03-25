package com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.AbilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAbilityRepository extends JpaRepository<AbilityEntity, Long> {
    Optional<AbilityEntity> findByName(String name);
}
