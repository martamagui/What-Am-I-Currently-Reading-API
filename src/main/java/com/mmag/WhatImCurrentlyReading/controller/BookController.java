package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.entity.Book;
import com.mmag.WhatImCurrentlyReading.service.BookService;
import org.apache.coyote.BadRequestException;
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

    @GetMapping("/search")
    public List<Book> getBooksByTitle(@RequestParam(name = "title") String sagaName) {
        return bookService.getBooksByTitle(sagaName);
    }
    //endregion GETS


    //region POST
    @PostMapping
    public void saveBook(@RequestBody Book book) throws BadRequestException {
        if (book.getAuthor().getId() != null) {
            bookService.saveOrUpdateBook(book);
        } else {
            throw new BadRequestException("Missing author");
        }
    }
    //endregion POST


    //region DELETE
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBookById(bookId);
    }
    //endregion DELETE
}
