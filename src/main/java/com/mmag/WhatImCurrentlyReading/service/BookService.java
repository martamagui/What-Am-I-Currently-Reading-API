package com.mmag.WhatImCurrentlyReading.service;

import com.mmag.WhatImCurrentlyReading.entity.Book;
import com.mmag.WhatImCurrentlyReading.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //region Getters
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public List<Book> getBooksByTitle(String bookTitle) {
        Book book = new Book();
        book.setBookTitle(bookTitle);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("book_title", ExampleMatcher.GenericPropertyMatcher::ignoreCase)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Book> bookExample = Example.of(book, matcher);
        return bookRepository.findAll(bookExample);
    }
    //endregion Getters

    //region Setters
    public void saveOrUpdateBook(Book book) {
        bookRepository.save(book);
    }
    //endregion Setters

    // region Delete
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
    //endregion Delete
}
