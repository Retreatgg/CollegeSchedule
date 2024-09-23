package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.AudienceDto;
import com.example.collegeschedule.dto.AudiencesTypeDto;
import com.example.collegeschedule.model.Audience;
import com.example.collegeschedule.model.AudiencesType;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AudienceTypeMapper.class})
public interface AudienceMapper {
    @Mapping(target = "typeDto", source = "type")
    AudienceDto toDto(Audience audience);
    List<AudienceDto> toListDto(List<Audience> audienceList);
    default AudiencesTypeDto mapToDto(AudiencesType audiencesType, @Context AudienceTypeMapper audienceTypeMapper) {
        return audienceTypeMapper.toDto(audiencesType);
    }
}
