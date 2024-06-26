package com.project.slotsync.service;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.User;
import com.project.slotsync.repository.UserRepository;
import com.project.slotsync.request.ChangeUserPasswordRequest;
import com.project.slotsync.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    PasswordEncoder encoder;

    public ApiResponse<User> showUserDetailsById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return new ApiResponse<>("User's details fetched successfully", user.get());
        }
        else {
            return new ApiResponse<>("No user found", null);
        }
    }

    public ApiResponse<User> showUserDetailsByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return new ApiResponse<>("User's details fetched successfully", user.get());
        }
        else {
            return new ApiResponse<>("No user found", null);
        }
    }

    public ApiResponse<String> verifyUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return new ApiResponse<>("User found", user.get().getUsername());
        }
        else {
            return new ApiResponse<>("No user found", null);
        }
    }

    public ApiResponse<List<User>> showAllUserDetails() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty()) {
            return new ApiResponse<>("No users found", null);
        } else {
            return new ApiResponse<>("Users' details fetched successfully", allUsers);
        }
    }

    public ApiResponse<User> updateExistingUserDetails(String username, UpdateUserRequest request) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            User newUser = existingUser.get();
            if (request.getName() != null) newUser.setName(request.getName());
            if (request.getEmail() != null)newUser.setEmail(request.getEmail());
            userRepository.save(newUser);
            return new ApiResponse<>("User's details updated successfully", newUser);
        } else {
            return new ApiResponse<>("No user found to update", null);
        }
    }

//    public ApiResponse<User> changePassword(String username, ChangeUserPasswordRequest request) {
//        Optional<User> existingUser = userRepository.findByUsername(username);
//        if (existingUser.isPresent()) {
//            User newUser = existingUser.get();
//            if (encoder.encode(request.getCurrentPassword()).equals(newUser.getPassword())) {
//                newUser.setName(encoder.encode(request.getNewPassword()));
//                userRepository.save(newUser);
//                return new ApiResponse<>("User's details updated successfully", newUser);
//            } else {
//                return new ApiResponse<>("Incorrect current password", null);
//            }
//
//        } else {
//            return new ApiResponse<>("No users found to update", null);
//        }
//    }
}
