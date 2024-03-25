package com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.AbilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAbilityRepository extends JpaRepository<AbilityEntity, Long> {
    Optional<AbilityEntity> findByName(String name);
    @Query("SELECT a FROM AbilityEntity a ORDER BY SIZE(a.technologies) ASC")
    List<AbilityEntity> findAllOrderByTechnologiesSizeAsc();

    @Query("SELECT a FROM AbilityEntity a ORDER BY SIZE(a.technologies) DESC")
    List<AbilityEntity> findAllOrderByTechnologiesSizeDesc();
}
