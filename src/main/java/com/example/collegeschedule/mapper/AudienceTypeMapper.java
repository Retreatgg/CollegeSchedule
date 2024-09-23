package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.AudiencesTypeDto;
import com.example.collegeschedule.model.AudiencesType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AudienceTypeMapper {
    AudiencesTypeDto toDto(AudiencesType audiencesType);
    List<AudiencesTypeDto> toListDto(List<AudiencesType> audiencesTypes);
}
