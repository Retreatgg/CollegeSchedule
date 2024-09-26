package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.ScheduleCreateDto;
import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.dto.ScheduleEditDto;
import com.example.collegeschedule.model.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public interface ScheduleService {
    ScheduleDto create(ScheduleCreateDto scheduleCreateDto);

    List<ScheduleDto> scheduleList(Long groupId, Long teacherId, Long audienceId, String dayOfWeek, LocalTime startTime, LocalTime endTime, Long disciplineId, Integer course);

    Schedule findById(Long scheduleId);

    ScheduleDto edit(Long id, ScheduleEditDto scheduleEditDto);
}
