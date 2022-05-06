package com.greg.reactive;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI serviceApiConfig() {
        return new OpenAPI()
                .info(new Info().title("Microservice Reactive API")
                        .description("microservice reactive")
                        .version("v0.0.1"));
    }
}
