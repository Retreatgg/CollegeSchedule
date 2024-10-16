package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.PostDeveloperCreateDto;
import com.example.collegeschedule.dto.PostDeveloperDto;
import com.example.collegeschedule.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/developers/posts")
public class DeveloperController {
    private final DeveloperService developerService;

    @PostMapping()
    public ResponseEntity<PostDeveloperDto> createPost(@ModelAttribute PostDeveloperCreateDto postDeveloperCreateDto) {
        return ResponseEntity.ok(developerService.createPost(postDeveloperCreateDto));
    }

    @GetMapping()
    public ResponseEntity<List<PostDeveloperDto>> posts() {
        return ResponseEntity.ok(developerService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDeveloperDto> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(developerService.getPost(id));
    }
}
