package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.exception.TeacherNotFoundException;
import com.example.collegeschedule.mapper.TeacherMapper;
import com.example.collegeschedule.model.Teacher;
import com.example.collegeschedule.repository.TeacherRepository;
import com.example.collegeschedule.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public List<TeacherDto> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.toListDto(teachers);
    }

    @Override
    public TeacherDto createTeacher(TeacherCreateDto teacherCreateDto) {
        Teacher teacher = teacherMapper.fromCreateDto(teacherCreateDto);
        teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public Teacher findById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException("Преподователь не был найден, ID: "+ teacherId));
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }
}
