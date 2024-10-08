package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-07T19:17:06+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public TeacherDto toTeacherDto(User user) {
        if ( user == null ) {
            return null;
        }

        TeacherDto.TeacherDtoBuilder teacherDto = TeacherDto.builder();

        teacherDto.patronymic( user.getPatronymic() );
        teacherDto.id( user.getId() );
        teacherDto.name( user.getName() );
        teacherDto.surname( user.getSurname() );

        return teacherDto.build();
    }

    @Override
    public List<TeacherDto> toListTeacherDto(List<User> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDto> list = new ArrayList<TeacherDto>( teachers.size() );
        for ( User user : teachers ) {
            list.add( toTeacherDto( user ) );
        }

        return list;
    }
}
