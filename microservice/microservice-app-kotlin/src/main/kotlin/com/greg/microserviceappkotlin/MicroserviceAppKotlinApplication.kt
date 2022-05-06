package com.greg.microserviceappkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceAppKotlinApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceAppKotlinApplication>(*args)
}
