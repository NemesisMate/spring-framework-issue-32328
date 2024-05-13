package com.example.store.server;

import com.example.common.CommonApi;
import com.example.common.CommonGenreApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final List<CommonApi<?, ?>> commonApis;

    @GetMapping("/{id}")
    public Mono<Store> getStore(@PathVariable String id, @RequestParam(required = false) String genre) {
        Flux<Object> items = (genre != null ? Flux.fromIterable(commonApis)
                .mapNotNull(api -> api instanceof CommonGenreApi<?, ?> genreApi ? genreApi : null)
                .flatMap(api -> api.getAllByGenre(genre))
                : Flux.fromIterable(commonApis).flatMap(CommonApi::getAll));

        return items.collectList()
                .map(list -> new Store(id, list));
    }
}
