package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.PostDeveloperCreateDto;
import com.example.collegeschedule.dto.PostDeveloperDto;
import com.example.collegeschedule.model.DeveloperPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    PostDeveloperDto createPost(PostDeveloperCreateDto postDeveloperCreateDto);
    List<PostDeveloperDto> getAllPosts();
    PostDeveloperDto getPost(Long id);
}
