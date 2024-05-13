package com.example.common;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;

public interface CommonGenreApi<ENTITY, ID> extends CommonApi<ENTITY, ID> {

    String NO_GENRE = "<NO_GENRE>";

    @GetMapping(params = "genre")
    @GetExchange
    Flux<ENTITY> getAllByGenre(@RequestParam(value = "genre") String genre);

    default Flux<ENTITY> getWithoutGenre() {
        return getAllByGenre(NO_GENRE);
    }

}
