package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.TeacherDto;
import com.example.collegeschedule.dto.UserDto;
import com.example.collegeschedule.model.User;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.patronymic( user.getPatronymic() );
        userDto.name( user.getName() );
        userDto.surname( user.getSurname() );

        return userDto.build();
    }

    @Override
    public List<TeacherDto> toListTeacherDto(List<User> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<TeacherDto> list = new ArrayList<TeacherDto>( teachers.size() );
        for ( User user : teachers ) {
            list.add( userToTeacherDto( user ) );
        }

        return list;
    }

    protected TeacherDto userToTeacherDto(User user) {
        if ( user == null ) {
            return null;
        }

        TeacherDto.TeacherDtoBuilder teacherDto = TeacherDto.builder();

        teacherDto.id( user.getId() );
        teacherDto.name( user.getName() );
        teacherDto.surname( user.getSurname() );
        teacherDto.patronymic( user.getPatronymic() );

        return teacherDto.build();
    }
}
