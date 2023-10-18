package com.shirajussalekin.lms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "senderReader_id")
    private Reader senderReader;

    @ManyToOne
    @JoinColumn(name = "receiverReader_id")
    private Reader receiverReader;

    @ManyToOne
    @JoinColumn(name = "senderEmployee_id")
    private Employee senderEmployee;

    @ManyToOne
    @JoinColumn(name = "receiverEmployee_id")
    private Employee receiverEmployee;

    @ManyToOne
    @JoinColumn(name = "senderAuthor_id")
    private Author senderAuthor;

    @ManyToOne
    @JoinColumn(name = "receiverAuthor_id")
    private Author receiverAuthor;

}
