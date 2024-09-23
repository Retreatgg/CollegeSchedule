package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplineDto {
    private Long id;
    private String name;
}
