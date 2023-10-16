package com.shirajussalekin.lms.services.impl;

import com.shirajussalekin.lms.dao.PrivilegeRepository;
import com.shirajussalekin.lms.dto.PrivilegeDto;
import com.shirajussalekin.lms.entities.Privilege;
import com.shirajussalekin.lms.exceptions.ResourceNotFoundException;
import com.shirajussalekin.lms.mappers.PrivilegeMapper;
import com.shirajussalekin.lms.services.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Override
    public PrivilegeDto createPrivilege(PrivilegeDto privilegeDto) {
        return PrivilegeMapper
                .mapToPrivilegeDto(privilegeRepository
                        .save(PrivilegeMapper
                                .mapToPrivilege(privilegeDto)));
    }

    @Override
    public PrivilegeDto getPrivilegeById(Long id) {
        return PrivilegeMapper
                .mapToPrivilegeDto(privilegeRepository
                        .findById(id)
                        .orElseThrow(
                        () -> new ResourceNotFoundException("The Privilege does not exist!!")
                ));
    }

    @Override
    public List<PrivilegeDto> getAllPrivileges() {
        return privilegeRepository
                .findAll()
                .stream()
                .map(
                        privilege -> PrivilegeMapper.mapToPrivilegeDto(privilege))
                .collect(Collectors.toList());
    }

    @Override
    public PrivilegeDto updatePrivilege(Long id, PrivilegeDto privilegeDto) {
        if (!privilegeRepository.existsById(id))
            throw new ResourceNotFoundException("The Privilege does not exist by given ID!!");
        Privilege privilege = new Privilege(
                privilegeDto.getId(),
                privilegeDto.getName(),
                privilegeDto.getDescription(),
                privilegeDto.getRoles()
        );
        return PrivilegeMapper
                .mapToPrivilegeDto(privilegeRepository
                        .save(privilege));
    }

    @Override
    public void deletePrivilege(Long id) {
        if (!privilegeRepository.existsById(id))
            throw new ResourceNotFoundException("The Privilege does not exist by given ID!!");

        privilegeRepository.deleteById(id);
    }
}
