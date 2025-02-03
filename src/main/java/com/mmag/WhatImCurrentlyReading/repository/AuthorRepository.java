package com.mmag.WhatImCurrentlyReading.repository;

import com.mmag.WhatImCurrentlyReading.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
