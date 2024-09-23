package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.UserTeacherDto;
import com.example.collegeschedule.mapper.UserMapper;
import com.example.collegeschedule.model.User;
import com.example.collegeschedule.repository.UserRepository;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserTeacherDto> findAllTeachers() {
        List<User> teachers = userRepository.findTeachers();
        return userMapper.toListTeacherDto(teachers);
    }

    @Override
    public User findById(Long teacherId) {
        return userRepository.findById(teacherId).orElseThrow();
    }
}
