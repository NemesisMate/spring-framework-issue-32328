package com.example.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CommonController<ENTITY, ID, REPO extends CommonRepository<ENTITY, ID>> implements CommonApi<ENTITY, ID> {

    protected final REPO repository;

    public CommonController(REPO repository) {
        this.repository = repository;
    }

    @Override
    @GetMapping
    public Flux<ENTITY> getAll() {
        return repository.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Mono<ENTITY> get(ID i) {
        return repository.findById(i);
    }

    @Override
    @PutMapping
    public Mono<ENTITY> put(ENTITY entity) {
        return repository.save(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public Mono<Void> delete(ID id) {
        return repository.deleteById(id);
    }
}
