package com.example.microserviciobootcamp.adapters.driving.http.service;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.example.microserviciobootcamp.domain.api.ITechnologyServicePort;
import com.example.microserviciobootcamp.domain.exception.EmptyFieldException;
import com.example.microserviciobootcamp.domain.exception.FieldExceedsCharactersException;
import com.example.microserviciobootcamp.domain.exception.MissingDataException;
import com.example.microserviciobootcamp.domain.model.Technology;
import com.example.microserviciobootcamp.domain.util.DomainConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TechnologyHandlerImpl implements ITechnologyHandler {

    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyServicePort technologyServicePort;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_DESCRIPTION_LENGTH = 90;


    @Override
    public void saveTechnology(AddTechnologyRequest request) {
        validateTechnology(request);
        Technology technology = technologyRequestMapper.addRequestToTechnology(request);
        technologyServicePort.saveTechnology(technology);
    }

    private void validateTechnology(AddTechnologyRequest request) {
        String nameTechnology = request.getName();
        String descriptionTechnology = request.getDescription();
        if (nameTechnology == null) {
            throw new MissingDataException(DomainConstants.Field.NAME.toString());
        } else if (descriptionTechnology == null) {
            throw new MissingDataException(DomainConstants.Field.DESCRIPTION.toString());
        }
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
}
