package com.project.slotsync.controller;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.User;
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

    @PostMapping("/signup")
    public ApiResponse<User> signupNewUser() {
        return null; //AuthController
    }

    @PostMapping("/login")
    public ApiResponse<User> loginExistingUser() {
        return null; //AuthController
    }

    @GetMapping("/{id}")
    public ApiResponse<User> showUserDetails(@PathVariable Long id) {
        return userService.showUserDetails(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateExistingUserDetails(@PathVariable Long id, @RequestBody User user) {
        return userService.updateExistingUserDetails(id, user);
        //Change Password, give options in frontend!
    }

    @PutMapping("/forgot-password")
    public ApiResponse<User> forgotPassword() {
        return null;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<User>> showAllUserDetails() {
        return userService.showAllUserDetails();
    }
}
