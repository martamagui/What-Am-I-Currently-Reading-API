package com.mmag.WhatImCurrentlyReading.service;

import com.mmag.WhatImCurrentlyReading.entity.Author;
import com.mmag.WhatImCurrentlyReading.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    //region Getters
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAuthorByName(String name) {
        Author author = new Author();
        author.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::ignoreCase)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Author> example = Example.of(author, matcher);

        return authorRepository.findAll(example);
    }
    //endregion Getters

    //region Setters
    public void saveOrUpdateAuthor(Author author) {
        authorRepository.save(author);
    }
    //endregion Setters
}
