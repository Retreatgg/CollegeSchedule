package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.PostDeveloperCreateDto;
import com.example.collegeschedule.dto.PostDeveloperDto;
import com.example.collegeschedule.mapper.DeveloperPostMapper;
import com.example.collegeschedule.model.DeveloperPost;
import com.example.collegeschedule.model.User;
import com.example.collegeschedule.repository.DeveloperPostRepository;
import com.example.collegeschedule.service.DeveloperService;
import com.example.collegeschedule.service.UserService;
import com.example.collegeschedule.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperPostRepository developerPostRepository;
    private final DeveloperPostMapper developerPostMapper;
    private final UserService userService;
    private final FileUtil fileUtil;

    @Override
    public PostDeveloperDto createPost(PostDeveloperCreateDto postDeveloperCreateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User author = userService.findByEmail(email);
        DeveloperPost developerPost = DeveloperPost.builder()
                .title(postDeveloperCreateDto.getTitle())
                .content(postDeveloperCreateDto.getContent())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .author(author)
                .idDeleted(false)
                .image(fileUtil.saveUploadedFile(postDeveloperCreateDto.getImage(), "/images"))
                .build();
        developerPostRepository.save(developerPost);
        return developerPostMapper.toDto(developerPost);
    }

    @Override
    public List<PostDeveloperDto> getAllPosts() {
        List<DeveloperPost> developerPosts = developerPostRepository.findAll();
        return developerPostMapper.toListDto(developerPosts);
    }

    @Override
    public PostDeveloperDto getPost(Long id) {
        DeveloperPost developerPost = developerPostRepository.findById(id).orElseThrow();
        return developerPostMapper.toDto(developerPost);
    }
}
