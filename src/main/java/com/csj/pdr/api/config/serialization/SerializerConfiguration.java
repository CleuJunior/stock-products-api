package com.csj.pdr.api.config.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerializerConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
