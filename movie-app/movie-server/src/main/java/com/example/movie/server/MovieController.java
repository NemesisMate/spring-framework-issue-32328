package com.example.movie.server;

import com.example.common.CommonGenreController;
import com.example.movie.api.Movie;
import com.example.movie.api.MovieApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController extends CommonGenreController<Movie, Integer, MovieRepository> implements MovieApi {
    public MovieController(MovieRepository repository) {
        super(repository);
    }
}
