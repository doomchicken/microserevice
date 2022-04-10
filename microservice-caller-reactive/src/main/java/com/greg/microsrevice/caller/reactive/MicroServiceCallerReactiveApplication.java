package com.greg.microsrevice.caller.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients(basePackages = "com.greg")
public class MicroServiceCallerReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCallerReactiveApplication.class, args);
	}

}
