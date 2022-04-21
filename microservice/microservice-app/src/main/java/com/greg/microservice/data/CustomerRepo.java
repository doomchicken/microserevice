package com.greg.microservice.data;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepo extends CrudRepository<CustomerEntity, UUID> {
}
