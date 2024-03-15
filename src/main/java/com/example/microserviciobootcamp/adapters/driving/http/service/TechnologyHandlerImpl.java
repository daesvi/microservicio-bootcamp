package com.example.microserviciobootcamp.adapters.driving.http.service;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.example.microserviciobootcamp.domain.exception.EmptyFieldException;
import com.example.microserviciobootcamp.domain.exception.FieldExceedsCharactersException;
import com.example.microserviciobootcamp.domain.exception.MissingDataException;
import com.example.microserviciobootcamp.domain.model.Technology;
import com.example.microserviciobootcamp.domain.spi.ITechnologyPersistencePort;
import com.example.microserviciobootcamp.domain.util.DomainConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TechnologyHandlerImpl implements ITechnologyHandler {

    private final ITechnologyPersistencePort technologyPersistencePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_DESCRIPTION_LENGTH = 90;


    @Override
    public void saveTechnology(AddTechnologyRequest request) {
        if (request.getName() == null) {
            throw new MissingDataException(DomainConstants.Field.NAME.toString());
        } else if (request.getDescription() == null) {
            throw new MissingDataException(DomainConstants.Field.DESCRIPTION.toString());
        }
        validateTechnology(request);
        Technology technology = technologyRequestMapper.addRequestToTechnology(request);
        technologyPersistencePort.saveTechnology(technology);
    }

    private void validateTechnology(AddTechnologyRequest request) {
        String nameTechnology = request.getName();
        String descriptionTechnology = request.getDescription();
        if (nameTechnology.isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }else if (nameTechnology.length()>50){
            throw new FieldExceedsCharactersException(DomainConstants.Field.NAME.toString());
        }
        if (descriptionTechnology.isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        } else if (descriptionTechnology.length()>90){
            throw new FieldExceedsCharactersException(DomainConstants.Field.DESCRIPTION.toString());
        }
    }

    private Technology mapRequestToTechnology(AddTechnologyRequest request) {
        return technologyRequestMapper.addRequestToTechnology(request);
    }
}
