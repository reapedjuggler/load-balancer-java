package com.userprofile.controller;

import com.userprofile.model.UserProfile;
import com.userprofile.repository.UserProfileRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {
    private final UserProfileRepository repository;

    public UserProfileController(UserProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String createUser(@RequestBody UserProfile profile) {
        repository.save(profile);
        return "User profile created!";
    }

    @PutMapping
    public String updateUser(@RequestBody UserProfile profile) {
        repository.save(profile);
        return "User profile updated!";
    }

    @GetMapping("/{id}")
    public UserProfile getUser(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }
}