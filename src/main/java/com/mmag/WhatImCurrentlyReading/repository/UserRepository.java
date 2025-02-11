package com.mmag.WhatImCurrentlyReading.repository;


import com.mmag.WhatImCurrentlyReading.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    Boolean existsByEmail(String Email);
}
