package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.*;
import com.example.collegeschedule.model.User;
import com.example.collegeschedule.repository.UserRepository;
import com.example.collegeschedule.service.EmailService;
import com.example.collegeschedule.service.UserService;
import com.example.collegeschedule.utils.AuthUtils;
import com.example.collegeschedule.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final EmailService emailService;
    private final AuthUtils authUtils;

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email: " + username + " еще не существует"));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean checkToken(String token) {
        Optional<User> userOptional = userRepository.findByToken(token);
        return userOptional.isEmpty();
    }

    @Override
    public User getUserByToken(String token) {
        return userRepository.findByToken(token).orElseThrow();
    }

    @Override
    public TokenDto login(UserLoginDto userLoginDto) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getEmail());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Неверный логин или пароль");
        }
        User user = userOptional.get();
        boolean isCorrectPassword = encoder.matches(userLoginDto.getPassword(), user.getPassword());
        if (!isCorrectPassword) {
            throw new IllegalArgumentException("Неверный логин или пароль");
        }
        return TokenDto.builder()
                .token(TokenUtils.generateToken(user))
                .build();
    }

    @Override
    public void logout() {
        User user = authUtils.getUserByAuth();
        TokenUtils.generateToken(user);
    }

    @Override
    public void forgotPassword(ForgotPasswordDto forgotPasswordDto) {
        User user = findByEmail(forgotPasswordDto.getEmail());
        String token = UUID.randomUUID().toString();
        user.setResetPasswordToken(token);
        emailService.sendMessage(user.getEmail(), token);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void resetPassword(ResetPasswordDto resetPasswordDto) {
        User user = findByEmail(resetPasswordDto.getEmail());
        if(user.getResetPasswordToken() != null && user.getResetPasswordToken().equals(resetPasswordDto.getCode())) {
            user.setPassword(encoder.encode(resetPasswordDto.getPassword()));
            user.setResetPasswordToken(null);
            user.setToken(TokenUtils.generateToken(user));
            userRepository.saveAndFlush(user);
        } else {
            throw new IllegalArgumentException("Неверный код подтверждения");
        }
    }

}
