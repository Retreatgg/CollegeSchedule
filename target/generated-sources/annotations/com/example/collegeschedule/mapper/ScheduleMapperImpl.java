package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.ScheduleDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.Schedule;
import com.example.collegeschedule.model.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T19:17:06+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private AudienceMapper audienceMapper;
    @Autowired
    private DisciplineMapper disciplineMapper;

    @Override
    public ScheduleDto toDto(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        ScheduleDto.ScheduleDtoBuilder scheduleDto = ScheduleDto.builder();

        scheduleDto.groupDto( groupMapper.toDto( schedule.getGroup() ) );
        scheduleDto.audienceDto( audienceMapper.toDto( schedule.getAudience() ) );
        scheduleDto.teacherDto( teacherToTeacherDto( schedule.getTeacher() ) );
        scheduleDto.disciplineDto( disciplineMapper.toDto( schedule.getDiscipline() ) );
        scheduleDto.startDate( schedule.getStartDate() );
        scheduleDto.endDate( schedule.getEndDate() );
        scheduleDto.dayOfWeek( schedule.getDayOfWeek() );
        scheduleDto.id( schedule.getId() );

        return scheduleDto.build();
    }

    @Override
    public List<ScheduleDto> toListDto(List<Schedule> schedules) {
        if ( schedules == null ) {
            return null;
        }

        List<ScheduleDto> list = new ArrayList<ScheduleDto>( schedules.size() );
        for ( Schedule schedule : schedules ) {
            list.add( toDto( schedule ) );
        }

        return list;
    }

    protected TeacherDto teacherToTeacherDto(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDto.TeacherDtoBuilder teacherDto = TeacherDto.builder();

        teacherDto.id( teacher.getId() );
        teacherDto.name( teacher.getName() );
        teacherDto.surname( teacher.getSurname() );
        teacherDto.patronymic( teacher.getPatronymic() );

        return teacherDto.build();
    }
}
