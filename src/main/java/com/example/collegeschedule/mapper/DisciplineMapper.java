package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.DisciplineDto;
import com.example.collegeschedule.model.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DisciplineMapper {
    DisciplineDto toDto(Discipline discipline);
    List<DisciplineDto> toListDto(List<Discipline> disciplineList);
}
