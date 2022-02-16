package com.example.demo.Contoller;


import com.example.demo.entity.ChatMessage;
import com.example.demo.entity.ChatRoom;
import com.example.demo.repo.ChatMessageRepo;
import com.example.demo.repo.ChatRoomRepo;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MessageController {

    private final ChatRoomRepo chatRoomRepo;
    private final ChatMessageRepo chatMessageRepo;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/{chatId}")
    public void chat(@Payload ChatMessage chatMessage, @DestinationVariable Long chatId){
        ChatRoom chatRoom = chatRoomRepo.getById(chatId);
        //chatMessage.setChatRoom(chatRoom);
        chatMessageRepo.save(chatMessage);
        //messagingTemplate.convertAndSendToUser(chatId.toString(), "/messages" , chatMessage);
        messagingTemplate.convertAndSend("/topic/message", "ПРИВЕТ");
    }
}
