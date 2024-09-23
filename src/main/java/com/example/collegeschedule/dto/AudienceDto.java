package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AudienceDto {
    private String number;
    private Integer floor;
    private AudiencesTypeDto typeDto;
}
