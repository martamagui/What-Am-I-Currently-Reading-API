package com.mmag.WhatImCurrentlyReading.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userNickName;
    private String userName;
    private String email;
    private String password;
}
