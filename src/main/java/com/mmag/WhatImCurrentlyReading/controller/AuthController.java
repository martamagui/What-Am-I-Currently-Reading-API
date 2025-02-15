package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.controller.model.request.LoginRequest;
import com.mmag.WhatImCurrentlyReading.controller.model.request.RegisterRequest;
import com.mmag.WhatImCurrentlyReading.controller.model.response.AuthResponse;
import com.mmag.WhatImCurrentlyReading.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping(value= "login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public  ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}
