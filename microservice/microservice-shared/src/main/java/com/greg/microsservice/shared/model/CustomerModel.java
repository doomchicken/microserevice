package com.greg.microsservice.shared.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerModel(UUID id, String name, LocalDateTime created) {
}
