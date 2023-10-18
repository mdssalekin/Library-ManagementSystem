package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Book> books;

    @OneToMany(mappedBy = "senderAuthor")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receiverAuthor")
    private List<Message> receivedMessages;

    public Author(
            Long id,
            String firstName,
            String lastName,
            String email,
            String gender,
            String contactNo,
            String imgUrl,
            Date dateOfBirth,
            Date creationDateTime,
            Set<Book> books
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
        this.books = books;
    }
}
