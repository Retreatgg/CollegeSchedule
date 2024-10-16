package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.model.Group;
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
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupDto toDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDto.GroupDtoBuilder groupDto = GroupDto.builder();

        groupDto.id( group.getId() );
        groupDto.name( group.getName() );

        return groupDto.build();
    }

    @Override
    public List<GroupDto> toListDto(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDto> list = new ArrayList<GroupDto>( groups.size() );
        for ( Group group : groups ) {
            list.add( toDto( group ) );
        }

        return list;
    }
}
