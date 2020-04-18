package com.bee.content.backend.service;

import com.bee.content.backend.dto.ChatMessageDTO;

import java.util.List;

public interface ChatService {

    List<ChatMessageDTO> retrieveChatMessage(String email);

    void sendMessageToSupport(String author, String content);
}
