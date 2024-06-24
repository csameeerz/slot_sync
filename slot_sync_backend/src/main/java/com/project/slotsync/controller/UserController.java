package com.project.slotsync.controller;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.User;
import com.project.slotsync.request.ChangeUserPasswordRequest;
import com.project.slotsync.request.UpdateUserRequest;
import com.project.slotsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<User> showUserDetailsById(@PathVariable Long id) {
        return userService.showUserDetailsById(id);
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<User> showUserDetailsByUsername(@PathVariable String username) {
        return userService.showUserDetailsByUsername(username);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<User>> showAllUserDetails() {
        return userService.showAllUserDetails();
    }

    @PutMapping("/{username}")
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<User> updateExistingUserDetails(@PathVariable String username, @RequestBody UpdateUserRequest request) {
        return userService.updateExistingUserDetails(username, request);
    }

//    @PutMapping("/{username}/change-password")
//    public ApiResponse<User> changePassword(@PathVariable String username, @RequestBody ChangeUserPasswordRequest request) {
//        return userService.changePassword(username, request);
//    }
}
