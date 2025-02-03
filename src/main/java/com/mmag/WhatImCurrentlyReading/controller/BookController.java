package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.entity.Book;
import com.mmag.WhatImCurrentlyReading.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    //region GETS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/saga/{sagaName}")
    public List<Book> getBookBySaga(@PathVariable("sagaName") String sagaName) {
        return bookService.getBooksBySaga(sagaName);
    }
    //endregion GETS


    //region POST
    @PostMapping
    public void saveBook(@RequestBody Book book) {
        bookService.saveOrUpdateBook(book);
    }
    //endregion POST


    //region DELETE
    @DeleteMapping("/{bookId}")
    public void saveBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBookById(bookId);
    }
    //endregion DELETE
}
