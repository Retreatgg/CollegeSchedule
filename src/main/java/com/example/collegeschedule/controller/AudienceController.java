package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.AudienceCreateDto;
import com.example.collegeschedule.dto.AudienceDto;
import com.example.collegeschedule.dto.AudiencesTypeDto;
import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.model.Audience;
import com.example.collegeschedule.service.AudienceService;
import com.example.collegeschedule.service.AudienceTypeService;
import com.example.collegeschedule.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/audiences")
public class AudienceController {
    private final AudienceService audienceService;
    private final AudienceTypeService audienceTypeService;

    @GetMapping
    public ResponseEntity<List<AudienceDto>> findAll() {
        return ResponseEntity.ok(audienceService.findAll());
    }

    @PostMapping
    public ResponseEntity<AudienceDto> create(@RequestBody AudienceCreateDto audienceCreateDto) {
        return ResponseEntity.ok(audienceService.create(audienceCreateDto));
    }

    @GetMapping("/types")
    public ResponseEntity<List<AudiencesTypeDto>> getTypes() {
        return ResponseEntity.ok(audienceTypeService.findAll());
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable Long id) {
        audienceService.delete(id);
        return HttpStatus.OK;
    }

}
