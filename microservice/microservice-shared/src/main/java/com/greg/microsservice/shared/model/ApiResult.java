package com.greg.microsservice.shared.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ApiResult(UUID id, boolean success, String message) {
}