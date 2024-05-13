package com.example.movie.server;

import com.example.common.CommonGenreRepository;
import com.example.movie.api.Movie;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovieRepository extends CommonGenreRepository<Movie, Integer> {
}
