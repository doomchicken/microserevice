package com.greg.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class MicroServiceReactiveApplication {

	public static void main(String[] args) {
//		Hooks.onOperatorDebug();
		SpringApplication.run(MicroServiceReactiveApplication.class, args);
	}


}
