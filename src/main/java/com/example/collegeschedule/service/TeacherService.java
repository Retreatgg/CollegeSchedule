package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> findAllTeachers();
    TeacherDto createTeacher(TeacherCreateDto teacherCreateDto);
    Teacher findById(Long teacherId);
    void delete(Long id);
}
