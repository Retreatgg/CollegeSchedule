package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.mapper.GroupMapper;
import com.example.collegeschedule.model.Group;
import com.example.collegeschedule.repository.GroupRepository;
import com.example.collegeschedule.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public List<GroupDto> findAll() {
        List<Group> groups = groupRepository.findAll();
        return groupMapper.toListDto(groups);
    }

    @Override
    public Group findById(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow();
    }
}
