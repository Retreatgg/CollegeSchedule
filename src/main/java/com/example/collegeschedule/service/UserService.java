package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.ForgotPasswordDto;
import com.example.collegeschedule.dto.ResetPasswordDto;
import com.example.collegeschedule.dto.TokenDto;
import com.example.collegeschedule.dto.UserLoginDto;
import com.example.collegeschedule.model.User;

public interface UserService {
    User findByEmail(String username);
    void save(User user);
    Boolean checkToken(String token);
    User getUserByToken(String token);
    TokenDto login(UserLoginDto userLoginDto);
    void logout();
    void forgotPassword(ForgotPasswordDto forgotPasswordDto);
    void resetPassword(ResetPasswordDto resetPasswordDto);
}
