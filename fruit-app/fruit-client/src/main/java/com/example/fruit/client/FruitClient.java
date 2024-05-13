package com.example.fruit.client;

import com.example.fruit.api.Fruit;
import com.example.fruit.api.FruitApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The current state of the client generator requires to override all methods that have any
 * generics which is far from ideal (also requiring to re-annotate the affected parameters)
 */
public interface FruitClient extends FruitApi {

    @Override
    Mono<Fruit> put(@RequestBody Fruit fruit);

    @Override
    Flux<Fruit> getAll();

    @Override
    Mono<Fruit> get(@PathVariable("id") Integer id);

    @Override
    Flux<Fruit> getAllByName(@RequestParam(value = "name") String name);
}
