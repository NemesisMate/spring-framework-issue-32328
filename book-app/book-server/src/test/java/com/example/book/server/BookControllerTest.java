package com.example.book.server;

import com.example.book.api.Book;
import com.example.book.client.BookClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BookControllerTest {

    @Autowired
    BookClient bookClient;

    @Test
    void test() {
        var genre = "fantasy";
        var author = "TestAuthor";
        var book = Book.withGenreAndAuthor(genre, author);
        var bookWithoutGenre = Book.withoutGenre(author);

        var registered = bookClient.put(book).block();
        var registeredWithoutGenre = bookClient.put(bookWithoutGenre).block();

        var fetchedBook = bookClient.get(registered.getId()).block();
        var fetchedByGenreBook = bookClient.getAllByGenre(genre).collectList().block();
        var fetchedWithoutGenre = bookClient.getWithoutGenre().collectList().block();
        var fetchedAllByAuthor = bookClient.getAllByAuthor(author).collectList().block();
        var fetchedAll = bookClient.getAll().collectList().block();
        bookClient.delete(fetchedBook.getId()).block();
        var fetchedDeletedBook = bookClient.get(fetchedBook.getId()).block();

        assertThat(fetchedBook).isEqualTo(registered);
        assertThat(fetchedByGenreBook).containsExactly(registered);
        assertThat(fetchedWithoutGenre).containsExactly(registeredWithoutGenre);
        assertThat(fetchedAll).containsExactly(registered, registeredWithoutGenre);
        assertThat(fetchedAllByAuthor).containsExactly(registered, registeredWithoutGenre);
        assertThat(fetchedDeletedBook).isNull();
    }


}
