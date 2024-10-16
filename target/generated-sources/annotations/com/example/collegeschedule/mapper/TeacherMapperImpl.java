package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.TeacherCreateDto;
import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-16T15:25:40+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDto toDto(Teacher teacher) {
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

    @Override
    public List<TeacherDto> toListDto(List<Teacher> teacherList) {
        if ( teacherList == null ) {
            return null;
        }

        List<TeacherDto> list = new ArrayList<TeacherDto>( teacherList.size() );
        for ( Teacher teacher : teacherList ) {
            list.add( toDto( teacher ) );
        }

        return list;
    }

    @Override
    public Teacher fromCreateDto(TeacherCreateDto teacherCreateDto) {
        if ( teacherCreateDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setName( teacherCreateDto.getName() );
        teacher.setSurname( teacherCreateDto.getSurname() );
        teacher.setPatronymic( teacherCreateDto.getPatronymic() );

        return teacher;
    }
}
