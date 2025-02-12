package com.mmag.WhatImCurrentlyReading.controller.model.response;

import com.mmag.WhatImCurrentlyReading.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String userNickName;
    private Set<User> following = new HashSet<>();
    private Set<User> followers = new HashSet<>();
}
