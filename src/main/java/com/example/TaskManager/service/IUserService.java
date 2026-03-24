package com.example.TaskManager.service;

import com.example.TaskManager.dto.Role;
import com.example.TaskManager.models.User;

public interface IUserService {
    public User register(String username, String rawPass, String email, Role role);

}
