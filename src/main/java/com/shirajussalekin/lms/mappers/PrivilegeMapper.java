package com.shirajussalekin.lms.mappers;

import com.shirajussalekin.lms.dto.PrivilegeDto;
import com.shirajussalekin.lms.entities.Privilege;

public class PrivilegeMapper {
    public static PrivilegeDto mapToPrivilegeDto(Privilege privilege){
        return new PrivilegeDto(
                privilege.getId(),
                privilege.getName(),
                privilege.getDescription(),
                privilege.getRoles()
        );
    }

    public static Privilege mapToPrivilege(PrivilegeDto privilegeDto){
        return new Privilege(
                privilegeDto.getId(),
                privilegeDto.getName(),
                privilegeDto.getDescription(),
                privilegeDto.getRoles()
        );
    }
}
