package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "book_price")
    private BigDecimal bookPrice;

    @Column(name = "book_img_url")
    private String bookImgUrl;

    @Column(name = "publication_name")
    private String publicationName;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDateTime;

    @ManyToMany(mappedBy = "books")
    private Set<Reader> readers;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
}
