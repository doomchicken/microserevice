package com.greg.microserviceappkotlin

import com.greg.microsservice.shared.model.ApiError
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.stream.Collectors

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(RuntimeException::class)
    protected fun handleRunTImeException(ex: RuntimeException): ResponseEntity<Any> {
        log.error(ex.message)
        val apiError = ApiError(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), ex.message)
        return buildResponseEntity(apiError)
    }

     override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val validationList = ex.bindingResult.fieldErrors.stream()
            .map { fieldError: FieldError -> "Field '" + fieldError.field + "' - " + fieldError.defaultMessage }
            .toList()
        val apiError =
            ApiError(HttpStatus.BAD_REQUEST, LocalDateTime.now(), java.lang.String.join("/n.", validationList))
        return buildResponseEntity(apiError)
    }

    private fun buildResponseEntity(apiError: ApiError): ResponseEntity<Any> {
        return ResponseEntity(apiError, apiError.status())
    }

    //other exception handlers below
}