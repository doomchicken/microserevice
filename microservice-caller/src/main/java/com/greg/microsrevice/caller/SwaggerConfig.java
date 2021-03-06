package com.greg.microsrevice.caller;

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
                .info(new Info().title("Microservice Caller API")
                        .description("microservice caller")
                        .version("v0.0.1"));
    }
}
