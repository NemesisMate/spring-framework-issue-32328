package com.example.common;

import reactor.core.publisher.Flux;

public abstract class CommonGenreController<ENTITY, ID, REPO extends CommonGenreRepository<ENTITY, ID>> extends CommonController<ENTITY, ID, REPO> implements CommonGenreApi<ENTITY, ID> {

    public CommonGenreController(REPO repository) {
        super(repository);
    }

    @Override
    public Flux<ENTITY> getAllByGenre(String genre) {
        return repository.findByGenre(genre);
    }
}
