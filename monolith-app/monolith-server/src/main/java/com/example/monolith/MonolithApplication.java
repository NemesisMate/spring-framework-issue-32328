package com.example.monolith;

import com.example.book.server.BookApplication;
import com.example.fruit.server.FruitApplication;
import com.example.movie.server.MovieApplication;
import com.example.store.server.StoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        BookApplication.class,
        MovieApplication.class,
        FruitApplication.class,
        StoreApplication.class
})
public class MonolithApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonolithApplication.class, args);
    }
}
