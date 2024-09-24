package com.example.collegeschedule.service.impl;

import com.example.collegeschedule.model.Role;
import com.example.collegeschedule.repository.RoleRepository;
import com.example.collegeschedule.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow();
    }
}
