package com.example.microserviciobootcamp.adapters.driven.jpa.mysql.repository;

import com.example.microserviciobootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBootcampRepository extends JpaRepository<BootcampEntity, Long> {
}
