package com.geekbrains.work16.services;

import com.geekbrains.work16.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}