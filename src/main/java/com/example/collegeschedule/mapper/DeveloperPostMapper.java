package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.PostDeveloperDto;
import com.example.collegeschedule.model.DeveloperPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface DeveloperPostMapper {
    @Mapping(target = "imageUrl", source = "image")
    PostDeveloperDto toDto(DeveloperPost developerPost);
    List<PostDeveloperDto> toListDto(List<DeveloperPost> developerPosts);
}
