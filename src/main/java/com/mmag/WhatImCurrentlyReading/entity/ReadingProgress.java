package com.mmag.WhatImCurrentlyReading.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reading_progress")
public class ReadingProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_progress_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "is_book_finished", nullable = false)
    private Boolean isBookFinished;

    @Column(name = "current_page", nullable = false)
    private int currentPage;

    @Column(name = "comment")
    private String comment;

    @Column(name = "last_update", nullable = false)
    private String lastUpdated;

}

