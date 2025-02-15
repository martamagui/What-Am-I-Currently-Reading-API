package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.controller.model.request.FollowUnfollowUserRequest;
import com.mmag.WhatImCurrentlyReading.controller.model.response.DefaultResponse;
import com.mmag.WhatImCurrentlyReading.controller.model.response.UserResponse;
import com.mmag.WhatImCurrentlyReading.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    //region GET
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> getUserById(@RequestParam(name = "userId") Long userId) {
        return ResponseEntity.ok(userService.getUserResponseById(userId));
    }
    //enregion GET


    //region POST
    @PostMapping(path ="/follow")
    public ResponseEntity<DefaultResponse> follow(
            @RequestBody FollowUnfollowUserRequest request,
            @RequestHeader(name = "Authorization") String token
    ) throws BadRequestException {
        return ResponseEntity.ok(userService.followUser(request, token));
    }

    @PostMapping(path ="/unfollow")
    public ResponseEntity<DefaultResponse> unFollow(
            @RequestBody FollowUnfollowUserRequest request,
            @RequestHeader(name = "Authorization") String token
    ) throws BadRequestException {
        return ResponseEntity.ok(userService.unfollowUser(request, token));
    }
    //endregion POST
}
