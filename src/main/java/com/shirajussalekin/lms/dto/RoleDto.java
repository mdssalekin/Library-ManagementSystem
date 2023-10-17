package com.shirajussalekin.lms.dto;

import com.shirajussalekin.lms.entities.Employee;
import com.shirajussalekin.lms.entities.Privilege;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String roleName;
    private String description;
    private Set<Privilege> privileges;
}
