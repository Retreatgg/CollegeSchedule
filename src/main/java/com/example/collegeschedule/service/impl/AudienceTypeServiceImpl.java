package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.AudiencesTypeDto;
import com.example.collegeschedule.mapper.AudienceTypeMapper;
import com.example.collegeschedule.model.AudiencesType;
import com.example.collegeschedule.repository.AudiencesTypeRepository;
import com.example.collegeschedule.service.AudienceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceTypeServiceImpl implements AudienceTypeService {
    private final AudiencesTypeRepository audiencesTypeRepository;
    private final AudienceTypeMapper audienceTypeMapper;

    @Override
    public AudiencesType findById(Long typeId) {
        return audiencesTypeRepository.findById(typeId).orElseThrow();
    }

    @Override
    public List<AudiencesTypeDto> findAll() {
        List<AudiencesType> types = audiencesTypeRepository.findAll();
        return audienceTypeMapper.toListDto(types);
    }
}
