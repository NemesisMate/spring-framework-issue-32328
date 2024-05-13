package com.example.common;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommonApi<ENTITY, ID> {

    @GetExchange
    Flux<ENTITY> getAll();

    @GetExchange(value = "/{id}")
    Mono<ENTITY> get(@PathVariable("id") ID id);

    @PutExchange
    Mono<ENTITY> put(@RequestBody ENTITY entity);

    @DeleteExchange(value = "/{id}")
    Mono<Void> delete(@PathVariable("id") ID id);
}
