package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.DisciplineDto;
import com.example.collegeschedule.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/disciplines")
public class DisciplineController {
    private final DisciplineService disciplineService;

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> findAll() {
        return ResponseEntity.ok(disciplineService.findAll());
    }

}
