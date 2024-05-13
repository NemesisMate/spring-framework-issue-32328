package com.example.fruit.server;

import com.example.common.CommonRepository;
import com.example.fruit.api.Fruit;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FruitRepository extends CommonRepository<Fruit, Integer> {
    Flux<Fruit> findAllByName(String name);
}
