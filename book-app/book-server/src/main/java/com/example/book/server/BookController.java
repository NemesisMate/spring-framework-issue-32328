package com.example.book.server;

import com.example.book.api.Book;
import com.example.book.api.BookApi;
import com.example.common.CommonGenreController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/book", "/books"})
public class BookController extends CommonGenreController<Book, Integer, BookRepository> implements BookApi {
    public BookController(BookRepository repository) {
        super(repository);
    }
}
