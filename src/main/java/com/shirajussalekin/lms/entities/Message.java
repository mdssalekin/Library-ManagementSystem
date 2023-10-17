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

//    @ManyToOne
//    @JoinColumn(name = "sender_id")
//    private Employee sender;
//
//    @ManyToOne
//    @JoinColumn(name = "receiver_id")
//    private Reader receiver;
}
