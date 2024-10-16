package com.example.collegeschedule.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDeveloperDto {
    private Long id;
    private String title;
    private String content;
    private String imageUrl;
    private UserDto author;
}
