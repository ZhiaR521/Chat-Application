package com.zhiar.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat/v2")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatMessageController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @PostMapping
    public ChatMessage sendMessage(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.saveMessage(chatMessage);
    }

    @GetMapping
    public List<ChatMessage> getAllMessages() {
        return chatMessageService.getAllMessages();
    }
}