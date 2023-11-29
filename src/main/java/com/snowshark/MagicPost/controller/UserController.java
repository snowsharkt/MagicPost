package com.snowshark.MagicPost.controller;

import com.snowshark.MagicPost.entities.User;
import com.snowshark.MagicPost.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/")
    public User saveUser(@Valid @RequestBody User user) throws Exception {
        return userServices.saveUser(user);
    }

    @GetMapping("/")
    public List<User> fetchUserList() {
        return userServices.fetchUserList();
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long userId) {
        userServices.deleteUserById(userId);
        return "Deleted Successful!";
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long userId,
                                       @Valid @RequestBody User user) throws Exception {
        return userServices.updateUser(userId, user);
    }

}
