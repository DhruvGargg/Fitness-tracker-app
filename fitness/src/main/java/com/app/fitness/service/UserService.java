package com.app.fitness.service;

import com.app.fitness.entity.User;
import com.app.fitness.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        userRepository.save(user);
        return user;
    }
}
