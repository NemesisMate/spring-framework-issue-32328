package com.example.book.api;

import com.example.common.CommonGenreApi;
import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "/book", contentType = MediaType.APPLICATION_JSON_VALUE, accept = MediaType.APPLICATION_JSON_VALUE)
public interface BookApi extends CommonGenreApi<Book, Integer> {
}
