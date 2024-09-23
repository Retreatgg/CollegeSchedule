package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ScheduleDto {
    private AudienceDto audienceDto;
    private UserTeacherDto userTeacherDto;
    private GroupDto groupDto;
    private DisciplineDto disciplineDto;
    private Instant startDate;
    private Instant endDate;
}
