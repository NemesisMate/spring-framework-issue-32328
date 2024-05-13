package com.example.fruit.server;

import com.example.common.CommonController;
import com.example.fruit.api.Fruit;
import com.example.fruit.api.FruitApi;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FruitController extends CommonController<Fruit, Integer, FruitRepository> implements FruitApi {
    public FruitController(FruitRepository repository) {
        super(repository);
    }

    @Override
    public Flux<Fruit> getAllByName(String name) {
        return repository.findAllByName(name);
    }
}
