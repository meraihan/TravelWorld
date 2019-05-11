package com.brainstation.socialmedia.TravelWorld.service;

import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.repository.UserRepository;
import com.brainstation.socialmedia.TravelWorld.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User addUser(User user) {
        user.setPassword(Helper.bCryptEncoder.encode((user.getPassword())));
        return userRepository.add(user);
    }
}