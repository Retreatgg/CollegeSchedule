package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.ScheduleCreateDto;
import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {
    ScheduleDto create(ScheduleCreateDto scheduleCreateDto);

    List<ScheduleDto> scheduleList();

    Schedule findById(Long scheduleId);
}
