package com.datcute.hello_spring_boot.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("!prod")
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI(@Value("${open.api.title}") String title,
                           @Value("${open.api.version}") String version,
                           @Value("${open.api.description}") String description,
                           @Value("${open.api.serverName}") String serverName,
                           @Value("${open.api.serverUrl}") String serverUrl) {
        return new OpenAPI().info(new Info().title("API-service document").version("v1.0")
                .description("This is a sample API service document").license(
                        new License().name("API License").url("http://domain.vn/license")
                )).servers(List.of(new Server().url("http://localhost:8080").description("Local server")));
    }

}
