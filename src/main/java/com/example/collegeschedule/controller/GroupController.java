package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ResponseEntity.ok(groupService.findAll());
    }
}
