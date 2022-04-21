package com.greg.reactive.data;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface CustomerRepo extends R2dbcRepository<CustomerEntity, UUID> {
}
