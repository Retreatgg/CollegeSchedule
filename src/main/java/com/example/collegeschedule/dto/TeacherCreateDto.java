package com.example.collegeschedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCreateDto {
    private String name;
    private String surname;
    private String patronymic;
}
