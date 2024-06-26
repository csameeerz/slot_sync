package com.project.slotsync.controller;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.User;
import com.project.slotsync.request.ChangeUserPasswordRequest;
import com.project.slotsync.request.UpdateUserRequest;
import com.project.slotsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<User>> showUserDetailsById(@PathVariable Long id) {
        ApiResponse<User> user = userService.showUserDetailsById(id);
        if (user.getData() != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
        }
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<User>> showUserDetailsByUsername(@PathVariable String username) {
        ApiResponse<User> user = userService.showUserDetailsByUsername(username);
        if (user.getData() != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
        }
    }

    @GetMapping("/verify/username/{username}")
    public ResponseEntity<ApiResponse<String>> verifyUsername(@PathVariable String username) {
        ApiResponse<String> user = userService.verifyUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<User>>> showAllUserDetails() {
        ApiResponse<List<User>> users = userService.showAllUserDetails();
        if (users.getData() != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users);
        }
    }

    @PutMapping("/{username}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApiResponse<User>> updateExistingUserDetails(@PathVariable String username, @RequestBody UpdateUserRequest request) {
        ApiResponse<User> user = userService.updateExistingUserDetails(username, request);
        if (user.getData() != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
        }
    }

//    @PutMapping("/{username}/change-password")
//    public ApiResponse<User> changePassword(@PathVariable String username, @RequestBody ChangeUserPasswordRequest request) {
//        return userService.changePassword(username, request);
//    }
}
