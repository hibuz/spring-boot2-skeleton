package com.hibuz.account.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {
    private static final String SCHEME_KEY = "Login";

    @Bean
    public OpenAPI swaggerApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(SCHEME_KEY, new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_KEY));
    }
}
