package com.example.microserviciobootcamp.domain.api.usecase;

import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import com.example.microserviciobootcamp.domain.exception.TechnologyAlreadyExistsException;
import com.example.microserviciobootcamp.domain.model.Technology;
import com.example.microserviciobootcamp.domain.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TechnologyUseCaseTest {
    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;

    private ITechnologyServicePort technologyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technologyService = new TechnologyUseCase(technologyPersistencePort);
    }

    @Test
    void saveTechnology_Successful() {
        Technology technology = new Technology(1L, "Java", "Programming language");
        when(technologyPersistencePort.findTechnologyByName("Java")).thenReturn(Optional.empty());
        when(technologyPersistencePort.saveTechnology(technology)).thenReturn(technology);

        Technology savedTechnology = technologyService.saveTechnology(technology);

        assertNotNull(savedTechnology);
        assertEquals(1L, savedTechnology.getId());
        assertEquals("Java", savedTechnology.getName());
        assertEquals("Programming language", savedTechnology.getDescription());
        verify(technologyPersistencePort, times(1)).findTechnologyByName("Java");
        verify(technologyPersistencePort, times(1)).saveTechnology(technology);
    }

    @Test
    void saveTechnology_AlreadyExists() {
        Technology technology = new Technology(1L, "Java", "Programming language");
        when(technologyPersistencePort.findTechnologyByName("Java")).thenReturn(Optional.of(technology));

        assertThrows(TechnologyAlreadyExistsException.class, () -> {
            technologyService.saveTechnology(technology);
        });

        verify(technologyPersistencePort, times(1)).findTechnologyByName("Java");
        verify(technologyPersistencePort, never()).saveTechnology(any());
    }

    @Test
    void getAllTechnologies() {
        Technology javaTechnology = new Technology(1L, "Java", "Programming language");
        when(technologyPersistencePort.getAllTechnologies(anyInt(), anyInt(), anyBoolean())).thenReturn(Collections.singletonList(javaTechnology));

        List<Technology> technologies = technologyService.getAllTechnologies(0, 10, true);

        assertNotNull(technologies);
        assertEquals(1, technologies.size());
        assertEquals(1L, technologies.get(0).getId());
        assertEquals("Java", technologies.get(0).getName());
        assertEquals("Programming language", technologies.get(0).getDescription());
        verify(technologyPersistencePort, times(1)).getAllTechnologies(0, 10, true);
    }


}
