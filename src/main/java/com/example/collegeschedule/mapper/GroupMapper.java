package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroupMapper {
    GroupDto toDto(Group group);
    List<GroupDto> toListDto(List<Group> groups);
}
