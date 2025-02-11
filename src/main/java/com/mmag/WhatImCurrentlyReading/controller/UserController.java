package com.mmag.WhatImCurrentlyReading.controller;

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

    //enregion GET


    //region POST
    //TODO follow and unfollow user

    //endregion POST
}
