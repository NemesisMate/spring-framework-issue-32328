package com.example.book.api;

import com.example.common.CommonGenreApi;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;

@RequestMapping({"/book", "/books"})
@HttpExchange(url = "/book", contentType = MediaType.APPLICATION_JSON_VALUE, accept = MediaType.APPLICATION_JSON_VALUE)
public interface BookApi extends CommonGenreApi<Book, Integer> {
    Flux<Book> getAllByGenre(String genre);
}
