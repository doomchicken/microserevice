package com.greg.microsrevice.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.greg")
@EnableReactiveFeignClients(basePackages = "com.greg")
public class MicroServiceCallerReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCallerReactiveApplication.class, args);
	}

}
