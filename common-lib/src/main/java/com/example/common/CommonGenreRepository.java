package com.example.common;

import reactor.core.publisher.Flux;

public interface CommonGenreRepository<ENTITY, ID> extends CommonRepository<ENTITY, ID> {
    Flux<ENTITY> findByGenre(String genre);
}
