package com.example.fruit.client;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@AutoConfiguration
@EnableConfigurationProperties(FruitClientProperties.class)
public class FruitClientAutoConfiguration {
    @Bean
    public FruitClient fruitClient(WebClient.Builder webClientBuilder, FruitClientProperties properties) {
        return HttpServiceProxyFactory.builder()
                .exchangeAdapter(WebClientAdapter.create(webClientBuilder
                        .baseUrl(properties.url())
                        .build()))
                .build().createClient(FruitClient.class);
    }
}
