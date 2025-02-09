package com.mmag.WhatImCurrentlyReading.service;

import com.mmag.WhatImCurrentlyReading.entity.User;
import com.mmag.WhatImCurrentlyReading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //region Get
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    //endregion Get

    //region Post
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }
    //endregion Post

    // region Post
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    //endregion Post
}
