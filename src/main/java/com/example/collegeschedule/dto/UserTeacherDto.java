package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTeacherDto {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
}
