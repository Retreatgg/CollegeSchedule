package com.example.collegeschedule.service;

import com.example.collegeschedule.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {
    void addToken(String token, User user);
    boolean containsKey(String token);
    UserDetails getUserDetailsByToken(String token);
    void deleteToken(String token);
}
