package com.example.microserviciobootcamp.adapters.driving.http.service.interface_handler;

import com.example.microserviciobootcamp.adapters.driving.http.dto.request.AddBootcampRequest;
import com.example.microserviciobootcamp.adapters.driving.http.dto.response.BootcampResponse;

public interface IBootcampHandler {
    BootcampResponse saveBootcamp(AddBootcampRequest request);
}
