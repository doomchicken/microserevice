package com.greg.microserviceappkotlin

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun serviceApiConfig(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("Microservice Kotlin API")
                    .description("microservice")
                    .version("v0.0.1")
            )
    }
}