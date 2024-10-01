package com.zhiar.chat;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class WebController {

    private final List<Message> messages = new ArrayList<>();

    @PostMapping("/messages")
    @ResponseBody
    public Message postMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @GetMapping("/messages")
    @ResponseBody
    public List<Message> getMessages() {
        return messages;
    }

    public static class Message {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}