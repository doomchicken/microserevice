package com.greg.microservice.data;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class CustomerEntity {
    @Column( columnDefinition = "TIMESTAMP",nullable = false, updatable = false)
    @CreationTimestamp
    protected LocalDateTime created;

    @Id
    @GeneratedValue
    protected UUID id;

    private String name;
}
