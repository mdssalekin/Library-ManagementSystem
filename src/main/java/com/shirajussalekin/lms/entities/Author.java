package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "imgUrl")
    private String imgUrl;

    public Author(
            Long id,
            String firstName,
            String lastName,
            String email,
            String gender,
            String contactNo,
            String imgUrl,
            Date dateOfBirth,
            Date creationDateTime
    ) {
        super(
                firstName,
                lastName,
                email,
                gender,
                contactNo,
                dateOfBirth,
                creationDateTime
        );
        this.id = id;
        this.imgUrl = imgUrl;
    }
}
