package com.example.common;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

public abstract class CommonGenreController<ENTITY, ID, REPO extends CommonGenreRepository<ENTITY, ID>> extends CommonController<ENTITY, ID, REPO> implements CommonGenreApi<ENTITY, ID> {

    public CommonGenreController(REPO repository) {
        super(repository);
    }

    @Override
    @GetMapping(params = "genre")
    public Flux<ENTITY> getAllByGenre(String g) {
        return repository.findByGenre(g);
    }

    @Override
    @GetMapping(params = "author")
    public Flux<ENTITY> getAllByAuthor(String author) {
        return repository.findByAuthor(author);
    }
}
