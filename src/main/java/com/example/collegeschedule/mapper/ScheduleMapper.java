package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScheduleMapper {
    ScheduleDto toDto(Schedule schedule);
    List<ScheduleDto> toListDto(List<Schedule> schedules);
}
