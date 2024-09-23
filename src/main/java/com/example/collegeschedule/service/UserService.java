package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.UserTeacherDto;
import com.example.collegeschedule.model.User;

import java.util.List;

public interface UserService {
    List<UserTeacherDto> findAllTeachers();

    User findById(Long teacherId);
}
