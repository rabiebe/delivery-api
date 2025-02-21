package com.service.delivery.web.dto.response;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class ApiErrorResponse {
    private final int status;
    private final String message;
    private final List<String> errors;

    public ApiErrorResponse(int status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiErrorResponse(int status, String message) {
        this(status, message, Collections.emptyList());
    }

}
