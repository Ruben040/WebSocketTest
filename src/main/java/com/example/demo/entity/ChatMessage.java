package com.example.demo.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "chat_message")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    @Column(name = "content")
    private String content;
//    @Column(name = "send_time")
//    private LocalDate timestamp;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MessageStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;
}
