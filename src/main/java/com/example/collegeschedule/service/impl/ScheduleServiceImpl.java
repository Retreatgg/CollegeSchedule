package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.dto.ScheduleCreateDto;
import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.dto.ScheduleEditDto;
import com.example.collegeschedule.mapper.GroupMapper;
import com.example.collegeschedule.mapper.ScheduleMapper;
import com.example.collegeschedule.model.Group;
import com.example.collegeschedule.model.Schedule;
import com.example.collegeschedule.repository.ScheduleRepository;
import com.example.collegeschedule.service.*;
import com.example.collegeschedule.specification.ScheduleSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final GroupService groupService;
    private final DisciplineService disciplineService;
    private final TeacherService teacherService;
    private final AudienceService audienceService;
    private final ScheduleMapper scheduleMapper;
    private final GroupMapper groupMapper;

    @Override
    public ScheduleDto create(ScheduleCreateDto scheduleCreateDto) {
        Schedule schedule = Schedule.builder()
                .group(groupService.findById(scheduleCreateDto.getGroupId()))
                .audience(audienceService.findById(scheduleCreateDto.getAudienceId()))
                .discipline(disciplineService.findById(scheduleCreateDto.getDisciplineId()))
                .teacher(teacherService.findById(scheduleCreateDto.getTeacherId()))
                .dayOfWeek(scheduleCreateDto.getDayOfWeek())
                .startDate(scheduleCreateDto.getStartDate())
                .endDate(scheduleCreateDto.getEndDate())
                .build();
        scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public List<ScheduleDto> scheduleList(
            Long groupId, Long teacherId, Long audienceId,
            String dayOfWeek, LocalTime startTime, LocalTime endTime,
            Long disciplineId, Integer course) {
        Specification<Schedule> spec = ScheduleSpecification
                .hasTeacher(teacherId)
                .and(ScheduleSpecification.hasAudience(audienceId))
                .and(ScheduleSpecification.hasDayOfWeek(dayOfWeek))
                .and(ScheduleSpecification.hasGroupId(groupId))
                .and(ScheduleSpecification.hasDiscipline(disciplineId))
                .and(ScheduleSpecification.betweenTime(startTime, endTime))
                .and(ScheduleSpecification.hasCourse(course))
                .and(ScheduleSpecification.orderByStartTime());
        List<Schedule> schedules = scheduleRepository.findAll(spec);
        return scheduleMapper.toListDto(schedules);
    }

    @Override
    public Schedule findById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow();
    }

    @Override
    public ScheduleDto edit(Long id, ScheduleEditDto scheduleEditDto) {
        Schedule schedule = Schedule.builder()
                .group(groupService.findById(scheduleEditDto.getGroupId()))
                .audience(audienceService.findById(scheduleEditDto.getAudienceId()))
                .discipline(disciplineService.findById(scheduleEditDto.getDisciplineId()))
                .teacher(teacherService.findById(scheduleEditDto.getTeacherId()))
                .dayOfWeek(scheduleEditDto.getDayOfWeek())
                .startDate(scheduleEditDto.getStartDate())
                .endDate(scheduleEditDto.getEndDate())
                .id(id)
                .build();
        scheduleRepository.save(schedule);
        return scheduleMapper.toDto(schedule);
    }

    @Override
    public List<GroupDto> getCountGroups(Long teacherId, String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        Specification<Schedule> spec = ScheduleSpecification.hasTeacher(teacherId)
                .and(ScheduleSpecification.hasDayOfWeek(dayOfWeek))
                .and(ScheduleSpecification.betweenTime(startTime, endTime));
        List<Schedule> schedules = scheduleRepository.findAll(spec);
        List<Group> groups = schedules.stream().map(Schedule::getGroup).toList();
        return groupMapper.toListDto(groups);
    }

    @Override
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
