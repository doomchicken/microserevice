package com.greg.microsservice.shared.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError (HttpStatus status, LocalDateTime timeStamp, String message) {
}