package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "employees_roles",
            joinColumns = @JoinColumn(
                    name = "employee_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "employee")
    private Set<Article> articles;


    public Employee(
            Long id,
            String firstName,
            String lastName,
            String email,
            String gender,
            String contactNo,
            Date dateOfBirth,
            Date joiningDateTime,
            Set<Role> roles,
            Set<Article> articles
    ) {
        super(
                firstName,
                lastName,
                email,
                gender,
                contactNo,
                dateOfBirth,
                joiningDateTime
        );
        this.id = id;
        this.roles = roles;
        this.articles = articles;

    }
}
