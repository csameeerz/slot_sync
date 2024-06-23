package com.project.slotsync.service;

import com.project.slotsync.constants.ApiResponse;
import com.project.slotsync.model.User;
import com.project.slotsync.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ApiResponse<User> showUserDetails(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return new ApiResponse<>("User's details fetched successfully", user.get());
        }
        else {
            return new ApiResponse<>("No users found", null);
        }
    }

    public ApiResponse<User> updateExistingUserDetails(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User newUser = existingUser.get();
            newUser.setName(user.getName());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            userRepository.save(newUser);
            return new ApiResponse<>("User's details updated successfully", newUser);
        } else {
            return new ApiResponse<>("No users found to update", null);
        }
    }

    public ApiResponse<List<User>> showAllUserDetails() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty()) {
            return new ApiResponse<>("No users found", null);
        } else {
            return new ApiResponse<>("All Users' details fetched successfully", allUsers);
        }
    }
}
