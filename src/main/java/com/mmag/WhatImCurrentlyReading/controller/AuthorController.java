package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.entity.Author;
import com.mmag.WhatImCurrentlyReading.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    //region GETS
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @RequestMapping(path = "/{authorId}")
    public Optional<Author> getAuthorById(@PathVariable("authorId") Long id) {
        return authorService.getAuthorById(id);
    }

    @RequestMapping(path = "/name/{authorName}")
    public List<Author> getAuthorByName(@PathVariable("authorId") String name) {
        return authorService.getAuthorByName(name);
    }
    //endregion GETS

    //region POST
    @PostMapping
    public void saveAuthor(@RequestBody Author author) {
        authorService.saveOrUpdateAuthor(author);
    }
    //endregion POST
}
