package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.mapper.UserMapper;
import com.example.collegeschedule.model.User;
import com.example.collegeschedule.model.UserRole;
import com.example.collegeschedule.repository.UserRepository;
import com.example.collegeschedule.repository.UserRoleRepository;
import com.example.collegeschedule.service.RoleService;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

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

}
