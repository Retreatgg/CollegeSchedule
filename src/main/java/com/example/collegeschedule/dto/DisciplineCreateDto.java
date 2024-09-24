package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class DisciplineCreateDto {
    private String name;
}
