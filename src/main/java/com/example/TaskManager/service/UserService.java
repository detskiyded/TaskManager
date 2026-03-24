package com.example.TaskManager.service;

import com.example.TaskManager.exception.UserAlreadyExistsException;
import com.example.TaskManager.dto.Role;
import com.example.TaskManager.models.User;
import com.example.TaskManager.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private UserRepository userRepo;
    private PasswordEncoder pwEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder pwEncoder){
        this.userRepo = userRepo;
        this.pwEncoder = pwEncoder;
    }

    @Override
    public User register(String username, String rawPass, String email, Role role) {
        if (userRepo.existsByUsername(username)){
            throw new UserAlreadyExistsException("Username taken");
        }
        User user = new User();
        user.setPassword(pwEncoder.encode(rawPass));
        user.setUsername(username);
        user.setEmail(email);
        user.setRole(role == null ? Role.USER : role);
        return userRepo.save(user);
    }
}

