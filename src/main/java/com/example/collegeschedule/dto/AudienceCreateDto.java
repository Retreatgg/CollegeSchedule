package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AudienceCreateDto {
    private String number;
    private Integer floor;
    private Integer capacity;
    private Long typeId;
}
