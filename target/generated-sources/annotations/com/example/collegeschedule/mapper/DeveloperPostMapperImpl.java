package com.example.collegeschedule.mapper;

import com.example.collegeschedule.dto.PostDeveloperDto;
import com.example.collegeschedule.model.DeveloperPost;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-16T13:00:15+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class DeveloperPostMapperImpl implements DeveloperPostMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PostDeveloperDto toDto(DeveloperPost developerPost) {
        if ( developerPost == null ) {
            return null;
        }

        PostDeveloperDto.PostDeveloperDtoBuilder postDeveloperDto = PostDeveloperDto.builder();

        postDeveloperDto.imageUrl( developerPost.getImage() );
        postDeveloperDto.id( developerPost.getId() );
        postDeveloperDto.title( developerPost.getTitle() );
        postDeveloperDto.content( developerPost.getContent() );
        postDeveloperDto.author( userMapper.toDto( developerPost.getAuthor() ) );

        return postDeveloperDto.build();
    }

    @Override
    public List<PostDeveloperDto> toListDto(List<DeveloperPost> developerPosts) {
        if ( developerPosts == null ) {
            return null;
        }

        List<PostDeveloperDto> list = new ArrayList<PostDeveloperDto>( developerPosts.size() );
        for ( DeveloperPost developerPost : developerPosts ) {
            list.add( toDto( developerPost ) );
        }

        return list;
    }
}
