package com.example.collegeschedule.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendMessage(String toEmail, String token);
}
