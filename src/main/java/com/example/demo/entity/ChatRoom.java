package com.example.demo.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chatroom")
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    @Column(name = "sender_id")
    private Long senderId;
    @Column(name = "recipient_id")
    private Long recipientId;
    @Column(name = "sender_name")
    private String senderName;
    @Column(name = "recipient_name")
    private String recipientName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "chatRoom")
    @EqualsAndHashCode.Exclude
    private List<ChatMessage> messageList;
}
