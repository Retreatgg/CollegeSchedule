package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ScheduleCreateDto {
    private Long groupId;
    private Long teacherId;
    private Long disciplineId;
    private Long audienceId;
    private Instant startDate;
    private Instant endDate;
}
