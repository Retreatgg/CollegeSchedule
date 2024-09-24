package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalTime;

@Data
@Builder
public class ScheduleDto {
    private Long id;
    private AudienceDto audienceDto;
    private UserTeacherDto userTeacherDto;
    private GroupDto groupDto;
    private DisciplineDto disciplineDto;
    private LocalTime startDate;
    private LocalTime endDate;
    private String dayOfWeek;
}
