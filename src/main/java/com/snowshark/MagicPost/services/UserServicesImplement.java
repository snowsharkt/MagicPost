package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.User;
import com.snowshark.MagicPost.errors.UserNotFoundException;
import com.snowshark.MagicPost.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServicesImplement implements UserServices{

    private UserRepository userRepository;


    public UserServicesImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws Exception {
        if (userRepository.existsByUsername(user.getUsername()))
            throw new Exception("Username existed!");
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserById(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("No user with this Id found!");
        }
        return user.get();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User user) throws Exception {
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isEmpty()) {
            throw new UserNotFoundException("No user with this Id found!");
        }
        User userDB = findUser.get();

        if (userRepository.existsByUsername(user.getUsername()))
            throw new Exception("Username existed!");
        if (Objects.nonNull(userDB.getUsername())
            && !userDB.getUsername().isEmpty()) {
            userDB.setUsername(user.getUsername());
        }

        if (Objects.nonNull(userDB.getPassword())
                && !userDB.getPassword().isEmpty()) {
            userDB.setUsername(user.getPassword());
        }

        return userRepository.save(userDB);
    }
}
