package com.project.slotsync.controller;

import com.project.slotsync.model.User;
import com.project.slotsync.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/users")
public class WebUserController {

    @Autowired
    private WebUserService webUserService;

    @GetMapping
    public List<User> findAll() {
        return webUserService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return webUserService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user) {
        return webUserService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return webUserService.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        webUserService.deleteById(id);
    }

}
