package com.example.microserviciobootcamp.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";
    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
}
