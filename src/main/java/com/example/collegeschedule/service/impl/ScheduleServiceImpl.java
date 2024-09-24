package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.ScheduleCreateDto;
import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.mapper.ScheduleMapper;
import com.example.collegeschedule.model.Schedule;
import com.example.collegeschedule.repository.ScheduleRepository;
import com.example.collegeschedule.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final GroupService groupService;
    private final DisciplineService disciplineService;
    private final UserService userService;
    private final AudienceService audienceService;
    private final ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDto create(ScheduleCreateDto scheduleCreateDto) {
        Schedule schedule = Schedule.builder()
                .group(groupService.findById(scheduleCreateDto.getGroupId()))
                .audience(audienceService.findById(scheduleCreateDto.getAudienceId()))
                .discipline(disciplineService.findById(scheduleCreateDto.getDisciplineId()))
                .teacher(userService.findById(scheduleCreateDto.getTeacherId()))
                .dayOfWeek(scheduleCreateDto.getDayOfWeek())
                .startDate(scheduleCreateDto.getStartDate())
                .endDate(scheduleCreateDto.getEndDate())
                .build();
        scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public List<ScheduleDto> scheduleList() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return scheduleMapper.toListDto(schedules);
    }

    @Override
    public Schedule findById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow();
    }
}
