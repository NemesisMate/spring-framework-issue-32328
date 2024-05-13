package com.example.movie.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("movie.client")
public record MovieClientProperties(
        @DefaultValue("http://localhost:8081")
        String url
) {
}
