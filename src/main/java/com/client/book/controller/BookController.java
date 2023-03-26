package com.client.book.controller;

import com.client.book.entity.Book;
import com.client.book.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


    Logger logger = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public Book getBook(@RequestParam String bookId){
        logger.info("Received request with bookId "+bookId);
        Book bookObj = bookService.getBook(bookId);
        logger.info("Book Obj Constructed ==>"+bookObj.toString());
        return bookObj;
    }
}
