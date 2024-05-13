package com.example.fruit.server;

import com.example.fruit.api.Fruit;
import com.example.fruit.client.FruitClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FruitControllerTest {

    @Autowired
    FruitClient fruitClient;

    @Test
    void test() {
        var name = "apple";
        var fruit = Fruit.withName(name);

        var registered = fruitClient.put(fruit).block();

        var fetchedFruit = fruitClient.get(registered.getId()).block();
        var fetchedByNameFruit = fruitClient.getAllByName(name).collectList().block();
        var fetchedAll = fruitClient.getAll().collectList().block();
        fruitClient.delete(fetchedFruit.getId()).block();
        var fetchedDeletedFruit = fruitClient.get(registered.getId()).block();

        assertThat(fetchedFruit).isEqualTo(registered);
        assertThat(fetchedByNameFruit).containsExactly(registered);
        assertThat(fetchedAll).containsExactly(registered);
        assertThat(fetchedDeletedFruit).isNull();
    }


}
