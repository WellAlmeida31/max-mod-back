package com.app.test.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("#{systemProperties['openapi.dev-url'] ?: 'http://localhost:8080'}")
    private String devUrl;

    @Bean
    public OpenAPI openAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("URL del servidor en el entorno de desarrollo");


        Contact contact = new Contact();
        contact.setEmail("wellington31almeida@gmail.com");
        contact.setName("Wellington Almeida");

        License mit = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Pruebla técnica")
                .version("1.0")
                .contact(contact)
                .description("Pruebla técnica Back End").termsOfService("")
                .license(mit);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
