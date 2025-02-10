package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.controller.model.request.LoginRequest;
import com.mmag.WhatImCurrentlyReading.controller.model.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {



    @PostMapping(value= "login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request){

        return ResponseEntity.ok(new AuthResponse());
    }

    @PostMapping(value = "register")
    public String register(){
        return "";
    }
}
