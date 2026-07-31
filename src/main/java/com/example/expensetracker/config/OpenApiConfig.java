package com.example.expensetracker.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI expenseTrackerAPI() {

        return new OpenAPI()

                .info(new Info()
                        .title("Smart Expense Tracker API"))

                .externalDocs(new ExternalDocumentation()

                        .description("GitHub Repository"));
    }
}