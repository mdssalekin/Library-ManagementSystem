package com.shirajussalekin.lms.dto;

import com.shirajussalekin.lms.entities.Article;
import com.shirajussalekin.lms.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String contactNo;
    private Date dateOfBirth;
    private Date joiningDateTime;
    private Role role;
    private Set<Article> articles;
}
