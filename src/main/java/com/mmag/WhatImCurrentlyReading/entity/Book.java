package com.mmag.WhatImCurrentlyReading.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "book_saga")
    private String bookSaga;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSaga() {
        return bookSaga;
    }

    public void setBookSaga(String bookSaga) {
        this.bookSaga = bookSaga;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
