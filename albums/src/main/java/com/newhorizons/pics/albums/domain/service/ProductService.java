package com.newhorizons.pics.albums.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private RestTemplate restTemplate = new RestTemplate();

    public String getProducts(){
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreakerFactory");
        String url = "http://localhost:8002/products/getAll";

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> getDefaultProducts());
    }

    private String getDefaultProducts() {
        try{
            return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("fallback-products.json").toURI())));
        }
        catch (Exception ex) {
            logger.error("Ocurrio un error.");
        }

        return null;
    }
}
