package com.example.TaskManager.service;

import com.example.TaskManager.models.User;
import com.example.TaskManager.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .map(user -> org.springframework.security.core.userdetails.User
                        .withUsername(username)
                        .password(user.getPassword())
                        .roles(user.getRole().name())
                                .build()
                        )
                .orElseThrow(()-> new UsernameNotFoundException("User " + username + " not found"));
    }
}