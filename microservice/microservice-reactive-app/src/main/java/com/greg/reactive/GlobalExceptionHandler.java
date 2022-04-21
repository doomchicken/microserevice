package com.greg.reactive;

import com.greg.microsservice.shared.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ApiError handleCustomException(Exception ex) {
//        log.error(ex.getMessage());
//        var apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), ex.getMessage());
//        return apiError;
//    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ApiError handleCustomException(WebExchangeBindException ex) {
        log.error(ex.getMessage());
        var validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> "Field '"+fieldError.getField() + "' - " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        var apiError = new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), String.join("/n.",validationList));
        return apiError;
    }
}