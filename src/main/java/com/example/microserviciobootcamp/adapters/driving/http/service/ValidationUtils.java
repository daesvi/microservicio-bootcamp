package com.example.microserviciobootcamp.adapters.driving.http.service;

import com.example.microserviciobootcamp.configuration.Constants;
import com.example.microserviciobootcamp.domain.exception.EmptyFieldException;
import com.example.microserviciobootcamp.domain.exception.FieldExceedsCharactersException;
import com.example.microserviciobootcamp.domain.exception.MissingDataException;
import com.example.microserviciobootcamp.domain.util.DomainConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationUtils {
    public void validateFields(String name, String description) {
        validateName(name);
        validateDescription(description);
    }
    private void validateName(String name) {
        if (name == null) {
            throw new MissingDataException(DomainConstants.Field.NAME.toString());
        }
        if (name.isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new FieldExceedsCharactersException(DomainConstants.Field.NAME.toString());
        }
    }

    private void validateDescription(String description) {
        if (description == null) {
            throw new MissingDataException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if (description.isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());
        }
        if (description.length() > Constants.MAX_DESCRIPTION_LENGTH) {
            throw new FieldExceedsCharactersException(DomainConstants.Field.DESCRIPTION.toString());
        }
    }

    public void validateListTechnologyIds(List<Long> technologyIds) {
        if (technologyIds == null){
            throw new MissingDataException(DomainConstants.Field.TECHNOLOGY_IDS.toString());
        }
    }

}
