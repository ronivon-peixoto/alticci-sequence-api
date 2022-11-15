package com.apps.alticci.exception;

import com.apps.alticci.model.ApiErrorsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    private static final String INTERNAL_SERVER_ERROR_MESSAGE = "An unexpected error occurred";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public final ApiErrorsDto handlerInternalServerError(Exception ex, WebRequest request) {
        return new ApiErrorsDto()
                .timestamp(new Date())
                .details(INTERNAL_SERVER_ERROR_MESSAGE);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorsDto handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(e -> errors.put(e.getPropertyPath().toString(), e.getMessage()));
        return new ApiErrorsDto()
                .timestamp(new Date())
                .errors(errors)
                .details(request.getDescription(false));
    }

}
