package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.AudiencesTypeDto;
import com.example.collegeschedule.model.AudiencesType;
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
public class AudienceTypeMapperImpl implements AudienceTypeMapper {

    @Override
    public AudiencesTypeDto toDto(AudiencesType audiencesType) {
        if ( audiencesType == null ) {
            return null;
        }

        AudiencesTypeDto.AudiencesTypeDtoBuilder audiencesTypeDto = AudiencesTypeDto.builder();

        audiencesTypeDto.id( audiencesType.getId() );
        audiencesTypeDto.name( audiencesType.getName() );

        return audiencesTypeDto.build();
    }

    @Override
    public List<AudiencesTypeDto> toListDto(List<AudiencesType> audiencesTypes) {
        if ( audiencesTypes == null ) {
            return null;
        }

        List<AudiencesTypeDto> list = new ArrayList<AudiencesTypeDto>( audiencesTypes.size() );
        for ( AudiencesType audiencesType : audiencesTypes ) {
            list.add( toDto( audiencesType ) );
        }

        return list;
    }
}
