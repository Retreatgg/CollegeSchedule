package com.example.collegeschedule.controller;

import com.example.collegeschedule.dto.DisciplineCreateDto;
import com.example.collegeschedule.dto.DisciplineDto;
import com.example.collegeschedule.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<DisciplineDto> createDiscipline(
            @RequestBody DisciplineCreateDto disciplineCreateDto
    ) {
        return ResponseEntity.ok(disciplineService.create(disciplineCreateDto));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDiscipline(@PathVariable Long id) {
        disciplineService.delete(id);
        return HttpStatus.OK;
    }

}
