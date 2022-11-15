package com.apps.alticci.exception;

import com.apps.alticci.model.ApiErrorsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

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

}
