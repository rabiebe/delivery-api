package com.service.delivery.web.controller;

import com.service.delivery.application.exception.delivery.DeliveryNotFoundException;
import com.service.delivery.application.exception.delivery.InvalidDeliveryException;
import com.service.delivery.application.exception.delivery.NullDeliveryException;
import com.service.delivery.domain.exception.delivery.InvalidDeliveryDateException;
import com.service.delivery.domain.exception.delivery.InvalidDeliveryModeException;
import com.service.delivery.web.dto.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeliveryNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleDeliveryNotFound(DeliveryNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(InvalidDeliveryException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDelivery(InvalidDeliveryException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(InvalidDeliveryModeException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDeliveryMode(InvalidDeliveryModeException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(InvalidDeliveryDateException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidDeliveryDate(InvalidDeliveryDateException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidUUID(MethodArgumentTypeMismatchException ex) {
        String paramName = ex.getName();
        String message = "Invalid format for parameter '" + paramName + "'. Expected a valid UUID.";
        return buildErrorResponse(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(NullDeliveryException.class)
    public ResponseEntity<ApiErrorResponse> handleNullDelivery(NullDeliveryException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Error", errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGlobalExceptions(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
    }

    private ResponseEntity<ApiErrorResponse> buildErrorResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status)
                .body(new ApiErrorResponse(status.value(), message, Collections.emptyList()));
    }
}

