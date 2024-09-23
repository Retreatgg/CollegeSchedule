package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.mapper.AudienceTypeMapper;
import com.example.collegeschedule.repository.AudiencesTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AudienceTypeServiceImpl {
    private final AudiencesTypeRepository audiencesTypeRepository;
    private final AudienceTypeMapper audienceTypeMapper;

}
