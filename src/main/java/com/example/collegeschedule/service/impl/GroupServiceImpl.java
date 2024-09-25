package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.GroupCreateDto;
import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.mapper.GroupMapper;
import com.example.collegeschedule.model.Group;
import com.example.collegeschedule.repository.GroupRepository;
import com.example.collegeschedule.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public List<GroupDto> findAll(Integer course) {
        List<Group> groups = groupRepository.findByCourse(course);
        return groupMapper.toListDto(groups);
    }

    @Override
    public Group findById(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow();
    }

    @Override
    public GroupDto create(GroupCreateDto groupCreateDto) {
        Group group = Group.builder()
                .name(groupCreateDto.getName())
                .course(groupCreateDto.getCourse())
                .build();
        groupRepository.save(group);
        return groupMapper.toDto(group);
    }
}
