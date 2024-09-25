package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.service.TeacherService;
import com.example.collegeschedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getTeachers() {
        return ResponseEntity.ok(teacherService.findAllTeachers());
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherCreateDto teacherCreateDto) {
        return ResponseEntity.ok(teacherService.createTeacher(teacherCreateDto));
    }
}
