package com.example.fruit.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("fruit.client")
public record FruitClientProperties(
        @DefaultValue("http://localhost:8081")
        String url
) {
}
