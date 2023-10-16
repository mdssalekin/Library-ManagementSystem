package com.shirajussalekin.lms.dto;

import com.shirajussalekin.lms.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeDto {
    private Long id;
    private String name;
    private String description;
    private Set<Role> roles;
}
