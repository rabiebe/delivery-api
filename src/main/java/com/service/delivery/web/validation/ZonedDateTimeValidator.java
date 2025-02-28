package com.service.delivery.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class ZonedDateTimeValidator implements ConstraintValidator<ValidZonedDateTime, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        try {
            ZonedDateTime.parse(value);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
