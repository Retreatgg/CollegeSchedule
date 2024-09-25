package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeacherMapper {

    TeacherDto toDto(Teacher teacher);
    List<TeacherDto> toListDto(List<Teacher> teacherList);
//    @Mapping(target = "enabled", defaultValue = "true")
    Teacher fromCreateDto(TeacherCreateDto teacherCreateDto);

}
