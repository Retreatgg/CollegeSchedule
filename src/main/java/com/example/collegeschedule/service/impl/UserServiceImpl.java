package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.UserTeacherDto;
import com.example.collegeschedule.mapper.UserMapper;
import com.example.collegeschedule.model.User;
import com.example.collegeschedule.model.UserRole;
import com.example.collegeschedule.repository.UserRepository;
import com.example.collegeschedule.repository.UserRoleRepository;
import com.example.collegeschedule.service.RoleService;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
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

    @Override
    public UserTeacherDto createTeacher(TeacherCreateDto teacherCreateDto) {
        User teacher = User.builder()
                .email(teacherCreateDto.getEmail())
                .enabled(true)
                .surname(teacherCreateDto.getSurname())
                .name(teacherCreateDto.getName())
                .patronymic(teacherCreateDto.getPatronymic())
                .password(encoder.encode(teacherCreateDto.getPassword()))
                .build();
        userRepository.save(teacher);
        UserRole userRole = UserRole.builder()
                .role(roleService.findById(1L))
                .user(teacher)
                .build();
        userRoleRepository.save(userRole);
        return userMapper.toTeacherDto(teacher);
    }

    @Override
    public User findByEmail(String username) {
        return userRepository.findByEmail(username).orElseThrow();
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

}
