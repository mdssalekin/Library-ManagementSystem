package com.shirajussalekin.lms.dto;

import com.shirajussalekin.lms.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String contactNo;
    private String imgUrl;
    private Date dateOfBirth;
    private Date creationDateTime = new Timestamp(new Date().getTime());
    private Set<Book> books;

}
