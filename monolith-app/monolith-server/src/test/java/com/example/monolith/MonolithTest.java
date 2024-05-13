package com.example.monolith;

import com.example.book.api.Book;
import com.example.fruit.api.Fruit;
import com.example.store.server.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MonolithTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void test() {
        var storeId = "TestStore";
        var genre = "fantasy";
        var author = "TestAuthor";

        var book = webTestClient.put()
                .uri("/books")
                .bodyValue(Book.withGenreAndAuthor(genre, author))
                .exchange()
                .expectBody(Object.class)
                .returnResult().getResponseBody();

        var fruit = webTestClient.put()
                .uri("/fruit")
                .bodyValue(Fruit.withName("apple"))
                .exchange()
                .expectBody(Object.class)
                .returnResult().getResponseBody();

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/store/" + storeId)
                        .queryParam("genre", genre)
                        .build())
                .exchange()
                .expectBody(Store.class)
                .isEqualTo(new Store(storeId, List.of(book)));
    }


}
