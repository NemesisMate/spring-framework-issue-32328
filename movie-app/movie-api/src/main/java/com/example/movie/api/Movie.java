package com.example.movie.api;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "example_db", name = "movie")
public class Movie {
    public static final String NO_GENRE = "<NO_GENRE>";

    @Id
    Integer id;
    String genre;

    public static Movie withGenre(String genre) {
        var movie = new Movie();
        movie.setGenre(genre);
        return movie;
    }

    public static Movie withoutGenre() {
        return withGenre(NO_GENRE);
    }
}
