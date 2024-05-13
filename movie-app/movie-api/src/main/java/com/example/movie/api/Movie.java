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
    String author;

    public static Movie withGenreAndAuthor(String genre, String author) {
        var movie = new Movie();
        movie.setGenre(genre);
        movie.setAuthor(author);
        return movie;
    }

    public static Movie withoutGenre(String author) {
        return withGenreAndAuthor(NO_GENRE, author);
    }
}
