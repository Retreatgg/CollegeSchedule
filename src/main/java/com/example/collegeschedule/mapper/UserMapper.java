package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "patronymic", source = "patronymic")
    TeacherDto toTeacherDto(User user);
    List<TeacherDto> toListTeacherDto(List<User> teachers);
}
