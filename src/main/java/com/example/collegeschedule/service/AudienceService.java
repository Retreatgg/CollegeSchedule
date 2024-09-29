package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.AudienceCreateDto;
import com.example.collegeschedule.dto.AudienceDto;
import com.example.collegeschedule.model.Audience;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AudienceService {
    List<AudienceDto> findAll();
    Audience findById(Long audienceId);
    AudienceDto create(AudienceCreateDto audienceCreateDto);
    void delete(Long id);
}
