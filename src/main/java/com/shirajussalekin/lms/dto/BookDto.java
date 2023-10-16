package com.shirajussalekin.lms.dto;

import com.shirajussalekin.lms.entities.Author;
import com.shirajussalekin.lms.entities.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal bookPrice;
    private String bookImgUrl;
    private String publicationName;
    private Date publicationDate;
    private Date creationDateTime = new Timestamp(new Date().getTime());
    private Set<Reader> readers;
    private Set<Author> authors;
}
