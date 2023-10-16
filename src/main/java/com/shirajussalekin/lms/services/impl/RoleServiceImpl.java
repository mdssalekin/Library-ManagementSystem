package com.shirajussalekin.lms.services.impl;

import com.shirajussalekin.lms.dao.RoleRepository;
import com.shirajussalekin.lms.dto.RoleDto;
import com.shirajussalekin.lms.entities.Role;
import com.shirajussalekin.lms.exceptions.ResourceNotFoundException;
import com.shirajussalekin.lms.mappers.RoleMapper;
import com.shirajussalekin.lms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return RoleMapper
                .mapToRoleDto(roleRepository
                        .save(RoleMapper
                                .mapToRole(roleDto)));
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return RoleMapper
                .mapToRoleDto(roleRepository
                        .findById(id)
                        .orElseThrow(
                () -> new ResourceNotFoundException("The Role does not exist by ID!!")
        ));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository
                .findAll()
                .stream()
                .map(
                        role -> RoleMapper.mapToRoleDto(role))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto roleDto) {
        if ((!roleRepository.existsById(id)))
            throw new ResourceNotFoundException("The Role does not exist by the given ID!!");

        Role role = new Role(
                roleDto.getId(),
                roleDto.getRoleName(),
                roleDto.getDescription(),
                roleDto.getEmployees(),
                roleDto.getPrivileges()
        );

        return RoleMapper.mapToRoleDto(roleRepository.save(role));
    }

    @Override
    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id))
            throw new ResourceNotFoundException("The Privilege does not exist by given ID!!");

        roleRepository.deleteById(id);

    }
}
