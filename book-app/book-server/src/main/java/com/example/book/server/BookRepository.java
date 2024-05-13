package com.example.book.server;

import com.example.book.api.Book;
import com.example.common.CommonGenreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CommonGenreRepository<Book, Integer> {
}
