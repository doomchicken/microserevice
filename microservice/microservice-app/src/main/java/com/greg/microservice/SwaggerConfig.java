package com.greg.microservice;

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
                .info(new Info().title("Microservice API")
                        .description("microservice")
                        .version("v0.0.1"));
    }
}
