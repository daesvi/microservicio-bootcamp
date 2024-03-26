package com.example.microserviciobootcamp.adapters.driving.http.service.handler_impl;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddBootcampRequest;
import com.example.microserviciobootcamp.adapters.driving.http.dto.response.BootcampResponse;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.IBootcampRequestMapper;
import com.example.microserviciobootcamp.adapters.driving.http.mapper.IBootcampResponseMapper;
import com.example.microserviciobootcamp.adapters.driving.http.service.ValidationUtils;
import com.example.microserviciobootcamp.adapters.driving.http.service.interface_handler.IBootcampHandler;
import com.example.microserviciobootcamp.domain.api.IBootcampServicePort;
import com.example.microserviciobootcamp.domain.model.Bootcamp;
import com.example.microserviciobootcamp.domain.util.DomainConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BootcampHandlerImpl implements IBootcampHandler {
    private final ValidationUtils validationUtils;
    private final IBootcampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;
    private final IBootcampServicePort bootcampServicePort;
    @Override
    public BootcampResponse saveBootcamp(AddBootcampRequest request) {
        validationUtils.validateNullList(request.getAbilityIds(), DomainConstants.Field.ABILITY_IDS.toString());
        validationUtils.validateNameAndDescription(request.getName(), request.getDescription());

        Bootcamp bootcamp = bootcampRequestMapper.addRequestToBootcamp(request);
        Bootcamp savedBootcamp = bootcampServicePort.saveBootcamp(bootcamp);
        return bootcampResponseMapper.toBootcampResponse(savedBootcamp);
    }
}
