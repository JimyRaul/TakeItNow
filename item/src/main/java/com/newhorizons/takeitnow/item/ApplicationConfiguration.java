package com.newhorizons.takeitnow.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean("restTemplateClient")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
