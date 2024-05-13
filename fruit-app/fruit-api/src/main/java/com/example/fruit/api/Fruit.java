package com.example.fruit.api;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "example_db", name = "fruit")
public class Fruit {
    @Id
    Integer id;
    String name;

    public static Fruit withName(String name) {
        var fruit = new Fruit();
        fruit.setName(name);
        return fruit;
    }
}
