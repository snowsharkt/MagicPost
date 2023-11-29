package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.User;
import com.snowshark.MagicPost.errors.UserNotFoundException;

import java.util.List;

public interface UserServices {
    public User saveUser(User user) throws Exception;
    public List<User> fetchUserList();
    public User fetchUserById(Long userId) throws UserNotFoundException;
    public void deleteUserById(Long userId);
    public User updateUser(Long userId, User user) throws Exception;
}
