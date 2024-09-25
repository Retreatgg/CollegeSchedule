package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.ScheduleCreateDto;
import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping()
    public ResponseEntity<ScheduleDto> createSchedule(
            @RequestBody ScheduleCreateDto scheduleCreateDto
    ) {
        return ResponseEntity.ok(scheduleService.create(scheduleCreateDto));
    }

    @GetMapping()
    public ResponseEntity<List<ScheduleDto>> schedules(
            @RequestParam(name = "groupId", defaultValue = "0") Long groupId,
            @RequestParam(name = "teacherId", defaultValue = "0") Long teacherId,
            @RequestParam(name = "audienceId", defaultValue = "0") Long audienceId,
            @RequestParam(name = "dayOfWeek", defaultValue = "default") String dayOfWeek,
            @RequestParam(name = "startTime", required = false) LocalTime startTime,
            @RequestParam(name = "endTime", required = false) LocalTime endTime,
            @RequestParam(name = "disciplineId", defaultValue = "0") Long disciplineId
            ) {
        return ResponseEntity.
                ok(scheduleService.scheduleList(
                        groupId, teacherId, audienceId, dayOfWeek, startTime, endTime, disciplineId
                ));
    }
}
