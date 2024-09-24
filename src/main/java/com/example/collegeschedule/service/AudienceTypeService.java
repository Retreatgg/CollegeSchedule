package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.AudiencesTypeDto;
import com.example.collegeschedule.model.AudiencesType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AudienceTypeService {
    AudiencesType findById(Long typeId);

    List<AudiencesTypeDto> findAll();
}
