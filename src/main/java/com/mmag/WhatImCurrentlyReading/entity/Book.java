package com.mmag.WhatImCurrentlyReading.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "book_saga")
    private String bookSaga;

}
