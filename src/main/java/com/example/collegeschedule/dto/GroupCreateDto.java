package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupCreateDto {
    private String name;
    private Integer course;
}
