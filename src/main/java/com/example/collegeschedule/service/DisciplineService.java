package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.DisciplineDto;
import com.example.collegeschedule.model.Discipline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DisciplineService {
    List<DisciplineDto> findAll();

    Discipline findById(Long disciplineId);
}
