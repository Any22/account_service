package com.fin_app.account_service.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigurationClass {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081/v1/api/users")
                .build();
    }
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


}
