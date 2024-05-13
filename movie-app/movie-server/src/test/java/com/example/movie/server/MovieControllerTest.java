package com.example.movie.server;

import com.example.movie.api.Movie;
import com.example.movie.client.MovieClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MovieControllerTest {

    @Autowired
    MovieClient movieClient;

    @Test
    void test() {
        var genre = "fantasy";
        var movie = Movie.withGenre(genre);
        var movieWithoutGenre = Movie.withoutGenre();

        var registered = movieClient.put(movie).block();
        var registeredWithoutGenre = movieClient.put(movieWithoutGenre).block();

        var fetchedMovie = movieClient.get(registered.getId()).block();
        var fetchedByGenreMovie = movieClient.getAllByGenre(genre).collectList().block();
        var fetchedWithoutGenre = movieClient.getWithoutGenre().collectList().block();
        var fetchedAll = movieClient.getAll().collectList().block();
        movieClient.delete(fetchedMovie.getId()).block();
        var fetchedDeletedMovie = movieClient.get(fetchedMovie.getId()).block();

        assertThat(fetchedMovie).isEqualTo(registered);
        assertThat(fetchedByGenreMovie).containsExactly(registered);
        assertThat(fetchedWithoutGenre).containsExactly(registeredWithoutGenre);
        assertThat(fetchedAll).containsExactly(registered, registeredWithoutGenre);
        assertThat(fetchedDeletedMovie).isNull();
    }


}
