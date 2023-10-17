package com.shirajussalekin.lms.mappers;

import com.shirajussalekin.lms.dto.RoleDto;
import com.shirajussalekin.lms.entities.Role;

public class RoleMapper {
    public static RoleDto mapToRoleDto(Role role) {
        return new RoleDto(
                role.getId(),
                role.getRoleName(),
                role.getDescription(),
                role.getPrivileges()
        );
    }

    public static Role mapToRole(RoleDto roleDto) {
        return new Role(
                roleDto.getId(),
                roleDto.getRoleName(),
                roleDto.getDescription(),
                roleDto.getPrivileges()
        );
    }

}
