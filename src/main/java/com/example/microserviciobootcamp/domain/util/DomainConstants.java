package com.example.microserviciobootcamp.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field{
        NAME,
        DESCRIPTION
    }

    public static final String TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The technology you want to create already exists";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String FIELD_EXCEEDS_CHARACTERS_EXCEPTION_MESSAGE = "Field %s exceeds limit character";
    public static final String MISSING_DATA_EXCEPTION_MESSAGE = "Field %s cannot be null";
}
