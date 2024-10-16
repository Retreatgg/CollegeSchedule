package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.ForgotPasswordDto;
import com.example.collegeschedule.dto.ResetPasswordDto;
import com.example.collegeschedule.dto.TokenDto;
import com.example.collegeschedule.dto.UserLoginDto;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<TokenDto> login(@RequestBody UserLoginDto userLoginDto) {
        return ResponseEntity.ok(userService.login(userLoginDto));
    }

    @PostMapping("/logout")
    public HttpStatus logout() {
        userService.logout();
        return HttpStatus.OK;
    }

    @PostMapping("/forgot-password")
    public HttpStatus forgotPassword(@RequestBody ForgotPasswordDto forgotPasswordDto) {
        userService.forgotPassword(forgotPasswordDto);
        return HttpStatus.OK;
    }

    @PostMapping("/reset-password")
    public HttpStatus resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        userService.resetPassword(resetPasswordDto);
        return HttpStatus.OK;
    }
}
