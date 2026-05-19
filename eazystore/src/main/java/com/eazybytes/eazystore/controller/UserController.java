package com.eazybytes.eazystore.controller;


import com.eazybytes.eazystore.entity.User;
import com.eazybytes.eazystore.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return repository.save(user);
    }
}
