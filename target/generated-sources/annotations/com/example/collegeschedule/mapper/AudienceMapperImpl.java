package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.AudienceDto;
import com.example.collegeschedule.model.Audience;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-16T15:25:40+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class AudienceMapperImpl implements AudienceMapper {

    @Autowired
    private AudienceTypeMapper audienceTypeMapper;

    @Override
    public AudienceDto toDto(Audience audience) {
        if ( audience == null ) {
            return null;
        }

        AudienceDto.AudienceDtoBuilder audienceDto = AudienceDto.builder();

        audienceDto.typeDto( audienceTypeMapper.toDto( audience.getType() ) );
        audienceDto.id( audience.getId() );
        audienceDto.number( audience.getNumber() );
        audienceDto.floor( audience.getFloor() );

        return audienceDto.build();
    }

    @Override
    public List<AudienceDto> toListDto(List<Audience> audienceList) {
        if ( audienceList == null ) {
            return null;
        }

        List<AudienceDto> list = new ArrayList<AudienceDto>( audienceList.size() );
        for ( Audience audience : audienceList ) {
            list.add( toDto( audience ) );
        }

        return list;
    }
}
