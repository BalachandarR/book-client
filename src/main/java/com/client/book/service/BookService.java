package com.client.book.service;

import com.client.book.controller.BookController;
import com.client.book.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {



    private RestTemplate restTemplate;

    @Value("${price.uri}")
    String priceServiceUri;

    Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Book getBook(String bookId){

        Book book = null;
        try {
            book = restTemplate.getForEntity(priceServiceUri+bookId, Book.class).getBody();
        } catch (RestClientException e) {
            logger.error("RestClientException occured  Trace==> " + e);
            throw new RuntimeException(e);
        }
        book.setBookName("Mastering ECS");
        book.setAuthor("AWS");
        return book;
    }

}
