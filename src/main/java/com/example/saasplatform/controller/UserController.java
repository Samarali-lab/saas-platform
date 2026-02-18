package com.example.saasplatform.controller;

import com.example.saasplatform.model.User;
import com.example.saasplatform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // Logic to register a user
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        // Logic to get user by ID
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        // Logic to get user by Email
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        // Logic to get all users
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        // Logic to update a user
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // Logic to delete a user
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}