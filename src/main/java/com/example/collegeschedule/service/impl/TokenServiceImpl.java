package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.model.User;
import com.example.collegeschedule.service.TokenService;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final UserService userService;
    private final AuthUserDetailServiceImpl authUserDetailService;
    @Override
    public void addToken(String token, User user) {
        user.setToken(token);
        userService.save(user);
    }

    @Override
    public boolean containsKey(String token) {
        return userService.checkToken(token);
    }

    @Override
    public UserDetails getUserDetailsByToken(String token) {
        User user = userService.getUserByToken(token);
        return authUserDetailService.loadUserByUsername(user.getEmail());
    }

    @Override
    public void deleteToken(String token) {
        User user = userService.getUserByToken(token);
        user.setToken(null);
        userService.save(user);
    }

}
