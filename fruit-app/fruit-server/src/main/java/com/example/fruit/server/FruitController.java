package com.example.fruit.server;

import com.example.common.CommonController;
import com.example.fruit.api.Fruit;
import com.example.fruit.api.FruitApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping({"/fruit", "/fruits"})
public class FruitController extends CommonController<Fruit, Integer, FruitRepository> implements FruitApi {
    public FruitController(FruitRepository repository) {
        super(repository);
    }

    @Override
    @GetMapping(params = "name")
    public Flux<Fruit> getAllByName(String name) {
        return repository.findAllByName(name);
    }
}
