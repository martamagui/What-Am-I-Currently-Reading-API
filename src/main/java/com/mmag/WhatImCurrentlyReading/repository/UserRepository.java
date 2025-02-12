package com.mmag.WhatImCurrentlyReading.repository;


import com.mmag.WhatImCurrentlyReading.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    Boolean existsByEmail(String Email);
    @Query("SELECT u.following FROM User u WHERE u.id = :userId")
    List<User> findFollowing(@Param("userId") Long userId);
    @Query("SELECT u.followers FROM User u WHERE u.id = :userId")
    List<User> findFollowers(@Param("userId")Long userId);
}

