package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.User;

import java.util.List;

public interface UserService {
    User findByEmail(String username);
    void save(User user);
    Boolean checkToken(String token);
    User getUserByToken(String token);
}
