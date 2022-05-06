package com.greg.microserviceappkotlin.web

import com.greg.microserviceappkotlin.data.CustomerEntity
import com.greg.microserviceappkotlin.data.CustomerRepo
import com.greg.microsservice.shared.model.ApiResult
import com.greg.microsservice.shared.model.CustomerCreateRequest
import com.greg.microsservice.shared.model.CustomerModel
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/customer")
class CustomerController(private val customerRepo: CustomerRepo) {

    @PostMapping
    fun createCustomer(@RequestBody request: CustomerCreateRequest): ApiResult {
        val customer = CustomerEntity(LocalDateTime.now(), UUID.randomUUID(),request.name)
        customerRepo.save(customer)
        return ApiResult(customer.id, true, "Customer created")
    }

    @GetMapping
    fun getAll(): List<CustomerModel>? {
       return customerRepo.findAll().asSequence().toList().stream().map { CustomerModel(it!!.id, it.name, it.created) }.toList()
    }
}