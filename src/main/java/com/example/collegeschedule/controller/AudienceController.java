package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.AudienceDto;
import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.model.Audience;
import com.example.collegeschedule.service.AudienceService;
import com.example.collegeschedule.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/audiences")
public class AudienceController {
    private final AudienceService audienceService;

    @GetMapping
    public ResponseEntity<List<AudienceDto>> findAll() {
        return ResponseEntity.ok(audienceService.findAll());
    }
}
