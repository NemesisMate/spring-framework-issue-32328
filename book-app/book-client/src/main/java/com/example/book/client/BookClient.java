package com.example.book.client;

import com.example.book.api.Book;
import com.example.book.api.BookApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The current state of the client generator requires to override all methods that have any
 * generics which is far from ideal (also requiring to re-annotate the affected parameters)
 */
public interface BookClient extends BookApi {

    @Override
    Mono<Book> put(@RequestBody Book book);

    @Override
    Flux<Book> getAll();

    @Override
    Mono<Book> get(@PathVariable("id") Integer id);

    @Override
    Flux<Book> getAllByGenre(@RequestParam(value = "genre") String genre);

    @Override
    Flux<Book> getAllByAuthor(@RequestParam(value = "author") String author);
}
