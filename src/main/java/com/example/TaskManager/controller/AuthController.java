package com.example.TaskManager.controller;

import com.example.TaskManager.dto.RegisterRequest;
import com.example.TaskManager.exception.UserAlreadyExistsException;
import com.example.TaskManager.dto.Role;
import com.example.TaskManager.models.User;
import com.example.TaskManager.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private IUserService userService;

    public AuthController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@Valid @RequestBody RegisterRequest request){
        try{
            User user = userService.register(
                    request.getUsername(),
                    request.getPassword(),
                    request.getEmail(),
                    Role.ADMIN
            );
            return ResponseEntity.ok(Map.of("message", "User registered", "username", user.getUsername(), "role", user.getRole().name()));
        }catch(UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
