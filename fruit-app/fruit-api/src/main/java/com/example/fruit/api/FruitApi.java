package com.example.fruit.api;

import com.example.common.CommonApi;
import com.example.common.CommonGenreApi;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;


@HttpExchange(url = "/fruit", contentType = MediaType.APPLICATION_JSON_VALUE, accept = MediaType.APPLICATION_JSON_VALUE)
public interface FruitApi extends CommonApi<Fruit, Integer> {
    @GetExchange
    Flux<Fruit> getAllByName(@RequestParam(value = "name") String name);
}
