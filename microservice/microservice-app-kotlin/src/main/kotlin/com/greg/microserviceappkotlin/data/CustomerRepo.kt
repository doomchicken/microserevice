package com.greg.microserviceappkotlin.data

import org.springframework.data.repository.CrudRepository
import java.util.*

interface CustomerRepo : CrudRepository<CustomerEntity?, UUID?>