package com.service.delivery.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ZonedDateTimeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidZonedDateTime {
    String message() default "Invalid date format, must be ISO-8601 (e.g., 2025-05-10T12:00:00Z)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
