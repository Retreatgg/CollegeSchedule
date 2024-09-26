package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.GroupCreateDto;
import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups(
            @RequestParam(name = "course", defaultValue = "0") Integer course
    ) {
        return ResponseEntity.ok(groupService.findAll(course));
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(
            @RequestBody GroupCreateDto groupCreateDto
    ) {
        return ResponseEntity.ok(groupService.create(groupCreateDto));
    }
}
