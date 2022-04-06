package com.greg.microsrevice;

import com.greg.microsservice.shared.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    protected ResponseEntity<Object> handleRunTImeException(
            RuntimeException ex) {
        var apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> "Field '"+fieldError.getField() + "' - " + fieldError.getDefaultMessage())                 .collect(Collectors.toList());

        var apiError = new ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), String.join("/n.",validationList));


        return buildResponseEntity(apiError);
    }


   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
       return new ResponseEntity<>(apiError, apiError.status());
   }

   //other exception handlers below

}