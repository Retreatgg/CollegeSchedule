package com.example.collegeschedule.service;

import com.example.collegeschedule.model.AudiencesType;
import org.springframework.stereotype.Service;

@Service
public interface AudienceTypeService {
    AudiencesType findById(Long typeId);
}
