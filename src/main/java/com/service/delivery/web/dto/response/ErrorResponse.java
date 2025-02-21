package com.service.delivery.web.dto.response;

import java.util.Collections;
import java.util.List;

public record ErrorResponse(int status, String message, List<String> errors) {
    public ErrorResponse(int status, String message) {
        this(status, message, Collections.emptyList());
    }
}
