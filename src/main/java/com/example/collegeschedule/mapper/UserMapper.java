package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.UserTeacherDto;
import com.example.collegeschedule.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "patronymic", source = "patronymic")
    UserTeacherDto toTeacherDto(User user);
    List<UserTeacherDto> toListTeacherDto(List<User> teachers);
}
