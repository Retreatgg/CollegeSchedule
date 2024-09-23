package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.UserTeacherDto;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {
    private final UserService userService;

    public ResponseEntity<List<UserTeacherDto>> getTeachers() {
        return ResponseEntity.ok(userService.findAllTeachers());
    }
}
