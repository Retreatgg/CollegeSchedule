package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.DisciplineCreateDto;
import com.example.collegeschedule.dto.DisciplineDto;
import com.example.collegeschedule.exception.DisciplineNotFoundException;
import com.example.collegeschedule.exception.RelatedEntityConstraintException;
import com.example.collegeschedule.mapper.DisciplineMapper;
import com.example.collegeschedule.model.Discipline;
import com.example.collegeschedule.repository.DisciplineRepository;
import com.example.collegeschedule.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplineServiceImpl implements DisciplineService {
    private final DisciplineRepository disciplineRepository;
    private final DisciplineMapper disciplineMapper;

    @Override
    public List<DisciplineDto> findAll() {
        List<Discipline> disciplines = disciplineRepository.findALl();
        return disciplineMapper.toListDto(disciplines);
    }

    @Override
    public Discipline findById(Long disciplineId) {
        return disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new DisciplineNotFoundException("Дисциплина по ID: "+ disciplineId + " не существует"));
    }

    @Override
    public DisciplineDto create(DisciplineCreateDto disciplineCreateDto) {
        Discipline discipline = Discipline.builder()
                .name(disciplineCreateDto.getName())
                .build();
        disciplineRepository.save(discipline);
        return disciplineMapper.toDto(discipline);
    }

    @Override
    public void delete(Long id) {
        try{
            disciplineRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RelatedEntityConstraintException("Дисциплина используется в расписании");
        }
    }
}
