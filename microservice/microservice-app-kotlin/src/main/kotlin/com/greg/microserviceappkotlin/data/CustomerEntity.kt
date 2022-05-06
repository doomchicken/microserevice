package com.greg.microserviceappkotlin.data

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class CustomerEntity (
    @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @CreationTimestamp
    val created: LocalDateTime,

    @Id
    @GeneratedValue
    val id: UUID,
    val name: String
)