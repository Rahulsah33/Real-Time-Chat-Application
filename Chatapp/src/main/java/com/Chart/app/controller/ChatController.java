package com.Chart.app.controller;

import com.Chart.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessages")      // client sends to /app/sendMessages
    @SendTo("/topic/messages")             // broker forwards to /topic/messages

    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}
