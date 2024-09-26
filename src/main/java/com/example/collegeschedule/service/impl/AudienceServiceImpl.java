package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.AudienceCreateDto;
import com.example.collegeschedule.dto.AudienceDto;
import com.example.collegeschedule.exception.AudienceNotFoundException;
import com.example.collegeschedule.mapper.AudienceMapper;
import com.example.collegeschedule.model.Audience;
import com.example.collegeschedule.repository.AudienceRepository;
import com.example.collegeschedule.service.AudienceService;
import com.example.collegeschedule.service.AudienceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceServiceImpl implements AudienceService {
    private final AudienceRepository audienceRepository;
    private final AudienceMapper audienceMapper;
    private final AudienceTypeService audienceTypeService;

    @Override
    public List<AudienceDto> findAll() {
        List<Audience> audiences = audienceRepository.findAll();
        return audienceMapper.toListDto(audiences);
    }

    @Override
    public Audience findById(Long audienceId) {
        return audienceRepository.findById(audienceId)
                .orElseThrow(() -> new AudienceNotFoundException("Аудитория не найдена по ID" + audienceId));
    }

    @Override
    public AudienceDto create(AudienceCreateDto audienceCreateDto) {
        Audience audience = Audience.builder()
                .floor(audienceCreateDto.getFloor())
                .capacity(audienceCreateDto.getCapacity())
                .number(audienceCreateDto.getNumber())
                .type(audienceTypeService.findById(audienceCreateDto.getTypeId()))
                .build();
        audienceRepository.save(audience);
        return audienceMapper.toDto(audience);
    }
}
