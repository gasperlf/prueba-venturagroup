package com.venturagroup.test.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    //TODO: define api title
    private static final String API_INFO_TITLE = "API";

    //TODO: define api description
    private static final String API_INFO_DESCRIPTION = "API INFO";

    //TODO: define api
    private static final String API_INFO_CONTACT_NAME = "API-CONTACT";

    //TODO: define api
    private static final String API_INFO_CONTACT_EMAIL = "EMAIL-CONTACT";

    //TODO: define api
    private static final String API_INFO_VERSION = "1.0.0";

    private static final String DEFAULT_REST_PACKAGE = "com.venturagroup.test.rest";

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(getApiInfo());
    }

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group(applicationName)
                .packagesToScan(DEFAULT_REST_PACKAGE)
                .build();
    }


    private Info getApiInfo() {
        return new Info()
                .title(API_INFO_TITLE)
                .description(API_INFO_DESCRIPTION)
                .contact(new Contact().name(API_INFO_CONTACT_NAME).email(API_INFO_CONTACT_EMAIL))
                .version(API_INFO_VERSION);
    }
}

