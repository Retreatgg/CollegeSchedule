package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.UserTeacherDto;
import com.example.collegeschedule.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserTeacherDto toTeacherDto(User user);
    List<UserTeacherDto> toListTeacherDto(List<User> teachers);
}
