package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalTime;

@Data
@Builder
public class ScheduleCreateDto {
    private Long groupId;
    private Long teacherId;
    private Long disciplineId;
    private Long audienceId;
    private LocalTime startDate;
    private LocalTime endDate;
}
