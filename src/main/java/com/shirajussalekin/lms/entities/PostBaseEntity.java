package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class PostBaseEntity {

    @Column(name = "article_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(
            name = "reader_id",
            referencedColumnName = "id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id")
    private Author author;
}
