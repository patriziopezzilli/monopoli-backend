package com.bee.content.backend.controller;

import com.bee.content.backend.dto.ChatMessageDTO;
import com.bee.content.backend.dto.ChatMessageMessageRequestDTO;
import com.bee.content.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/chat/messages", method = RequestMethod.GET)
    public List<ChatMessageDTO> getMessages(@RequestParam String email) {
        return chatService.retrieveChatMessage(email);
    }

    @RequestMapping(value = "/chat/messages", method = RequestMethod.POST)
    public void sendMessageToSupport(@RequestBody ChatMessageMessageRequestDTO request) {
        chatService.sendMessageToSupport(request.getAuthor(), request.getMessage());
    }
}
