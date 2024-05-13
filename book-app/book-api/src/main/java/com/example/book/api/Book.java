package com.example.book.api;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(schema = "example_db", name = "book")
public class Book {
    public static final String NO_GENRE = "<NO_GENRE>";

    @Id
    Integer id;
    String genre;
    String author;

    public static Book withGenreAndAuthor(String genre, String author) {
        var book = new Book();
        book.setGenre(genre);
        book.setAuthor(author);
        return book;
    }

    public static Book withoutGenre(String author) {
        return withGenreAndAuthor(NO_GENRE, author);
    }
}
