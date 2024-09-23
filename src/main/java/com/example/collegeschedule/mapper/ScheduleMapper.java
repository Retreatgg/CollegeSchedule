package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {GroupMapper.class, AudienceMapper.class, UserMapper.class, DisciplineMapper.class})
public interface ScheduleMapper {
    @Mapping(target = "groupDto", source = "group")
    @Mapping(target = "audienceDto", source = "audience")
    @Mapping(target = "userTeacherDto", source = "teacher")
    @Mapping(target = "disciplineDto", source = "discipline")
    ScheduleDto toDto(Schedule schedule);
    List<ScheduleDto> toListDto(List<Schedule> schedules);
}
