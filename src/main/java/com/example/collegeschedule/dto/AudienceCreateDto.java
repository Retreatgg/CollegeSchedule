package com.example.collegeschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudienceCreateDto {
    private String number;
    private Integer floor;
    private Integer capacity;
    private Long typeId;
}
