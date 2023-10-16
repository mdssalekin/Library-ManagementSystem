package com.shirajussalekin.lms.services;

import com.shirajussalekin.lms.dto.PrivilegeDto;

import java.util.List;

public interface PrivilegeService {
    PrivilegeDto createPrivilege(PrivilegeDto privilegeDto);

    PrivilegeDto getPrivilegeById(Long id);

    List<PrivilegeDto> getAllPrivileges();

    PrivilegeDto updatePrivilege(Long id, PrivilegeDto privilegeDto);

    void deletePrivilege(Long id);
}
