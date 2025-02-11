package com.mmag.WhatImCurrentlyReading.service;

import com.mmag.WhatImCurrentlyReading.controller.model.request.LoginRequest;
import com.mmag.WhatImCurrentlyReading.controller.model.request.RegisterRequest;

import com.mmag.WhatImCurrentlyReading.controller.model.response.AuthResponse;
import com.mmag.WhatImCurrentlyReading.entity.Role;
import com.mmag.WhatImCurrentlyReading.entity.User;
import com.mmag.WhatImCurrentlyReading.jwt.JWTUtil;
import com.mmag.WhatImCurrentlyReading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Primary
public class UserService implements UserDetailsService {


    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //region Get
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    //endregion Get

    //region Post
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya está en uso");
        }
        String password = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .userNickName(request.getUserNickName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(password)
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String token = jwtUtil.generateToken(request.getUserName());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return new AuthResponse(token);
        } else {
            throw new RuntimeException("Unauthorized");
        }
    }

    //endregion Post

    // region Post
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //endregion Post

}
