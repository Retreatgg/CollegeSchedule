package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.ScheduleCreateDto;
import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ScheduleDto>> schedules() {
        return ResponseEntity.ok(scheduleService.scheduleList());
    }
}
