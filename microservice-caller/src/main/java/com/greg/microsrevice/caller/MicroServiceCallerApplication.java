package com.greg.microsrevice.caller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.greg")
public class MicroServiceCallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCallerApplication.class, args);
	}


}
