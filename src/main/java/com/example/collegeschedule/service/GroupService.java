package com.example.collegeschedule.service;

import com.example.collegeschedule.dto.GroupCreateDto;
import com.example.collegeschedule.dto.GroupDto;
import com.example.collegeschedule.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService{
    List<GroupDto> findAll(Integer course);
    Group findById(Long groupId);
    GroupDto create(GroupCreateDto groupCreateDto);
    void delete(Long id);
}
