package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_name")
    private String articleName;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postingDate;

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
}
