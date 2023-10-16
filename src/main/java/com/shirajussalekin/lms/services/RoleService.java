package com.shirajussalekin.lms.services;

import com.shirajussalekin.lms.dto.RoleDto;
import com.shirajussalekin.lms.entities.Role;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);

    RoleDto getRoleById(Long id);

    List<RoleDto> getAllRoles();

    RoleDto updateRole(Long id, RoleDto roleDto);

    void deleteRole(Long id);
}
