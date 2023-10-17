package com.shirajussalekin.lms.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reader extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "reader")
    private Set<Article> articles;

    @ManyToMany
    @JoinTable(
            name = "readers_books",
            joinColumns = @JoinColumn(
                    name = "reader_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"))
    private Set<Book> books;

//    @OneToMany(mappedBy = "sender")
//    private List<Message> sentMessages;
//
//    @OneToMany(mappedBy = "receiver")
//    private List<Message> receivedMessages;

}
