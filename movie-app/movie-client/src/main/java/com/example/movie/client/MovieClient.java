package com.example.movie.client;

import com.example.movie.api.Movie;
import com.example.movie.api.MovieApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The current state of the client generator requires to override all methods that have any
 * generics which is far from ideal (also requiring to re-annotate the affected parameters)
 */
public interface MovieClient extends MovieApi {

    @Override
    Mono<Movie> put(@RequestBody Movie movie);

    @Override
    Mono<Void> delete(@PathVariable("id") Integer id);

    @Override
    Flux<Movie> getAll();

    @Override
    Mono<Movie> get(@PathVariable("id") Integer id);

    default Flux<Movie> getWithoutGenre() {
        return getAllByGenre(Movie.NO_GENRE);
    }
}
