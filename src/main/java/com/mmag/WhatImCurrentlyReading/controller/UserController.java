package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.entity.Saga;
import com.mmag.WhatImCurrentlyReading.entity.User;
import com.mmag.WhatImCurrentlyReading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    //region GET
    @RequestMapping
    public Optional<User> getUserById(Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        User user = userOptional.get();
        user.setPassword(null);
        user.setEmail(null);
        return Optional.of(user);
    }
    //enregion GET


    //region POST
    @PostMapping(path = "/signUp")
    public void signUp(User user) {
        userService.saveOrUpdateUser(user);
    }

    //TODO: login and change password

    //endregion POST
}
