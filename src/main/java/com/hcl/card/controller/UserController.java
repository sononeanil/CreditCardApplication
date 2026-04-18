package com.hcl.card.controller;

import com.hcl.card.exception.InvalidUserDataException;
import com.hcl.card.service.UserService;
import com.hcl.card.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();

    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidUserDataException("Email is required");
        }
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
       return userService.updateUser(id,updatedUser);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

    }
}
