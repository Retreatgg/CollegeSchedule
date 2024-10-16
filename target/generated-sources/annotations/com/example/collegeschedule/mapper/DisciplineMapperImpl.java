package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.DisciplineDto;
import com.example.collegeschedule.model.Discipline;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-16T11:28:02+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class DisciplineMapperImpl implements DisciplineMapper {

    @Override
    public DisciplineDto toDto(Discipline discipline) {
        if ( discipline == null ) {
            return null;
        }

        DisciplineDto.DisciplineDtoBuilder disciplineDto = DisciplineDto.builder();

        disciplineDto.name( discipline.getName() );
        disciplineDto.id( discipline.getId() );

        return disciplineDto.build();
    }

    @Override
    public List<DisciplineDto> toListDto(List<Discipline> disciplineList) {
        if ( disciplineList == null ) {
            return null;
        }

        List<DisciplineDto> list = new ArrayList<DisciplineDto>( disciplineList.size() );
        for ( Discipline discipline : disciplineList ) {
            list.add( toDto( discipline ) );
        }

        return list;
    }
}
