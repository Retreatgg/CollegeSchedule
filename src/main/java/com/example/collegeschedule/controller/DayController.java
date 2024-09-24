package com.example.collegeschedule.controller;

import com.example.collegeschedule.enums.Day;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/days")
public class DayController {

    @GetMapping()
    public ResponseEntity<List<String>> getDays() {
        return ResponseEntity.ok(Arrays.stream(Day.values()).map(Day::getDay).toList());
    }

}
