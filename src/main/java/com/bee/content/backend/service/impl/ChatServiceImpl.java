package com.bee.content.backend.service.impl;

import com.bee.content.backend.database.entity.ChatMessage;
import com.bee.content.backend.database.repository.ChatRepository;
import com.bee.content.backend.dto.ChatMessageDTO;
import com.bee.content.backend.service.ChatService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static String SUPPORT_NAME = "Bee Content Support";
    
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<ChatMessageDTO> retrieveChatMessage(String email) {
        List<ChatMessageDTO> response = new ArrayList<>();

        List<ChatMessage> messages = chatRepository.findByFromOrAndTo(email, email);
        if(null != messages) {
            messages.forEach(c -> {
                String dataStr = formatter.format(new Date());
                String from = SUPPORT_NAME.equalsIgnoreCase(c.getFrom()) ? SUPPORT_NAME : "You";

                response.add(
                        new ChatMessageDTO(
                                from,
                                dataStr,
                                c.getMessage()
                        )
                );
            });
        }

        return response;
    }

    @Override
    public void sendMessageToSupport(String author, String content) {
        ChatMessage message = new ChatMessage();

        message.setFrom(author);
        message.setTo(SUPPORT_NAME);
        message.setMessage(content);
        message.setMerchant(ThreadState.INSTANCE.getMerchant());

        chatRepository.save(
                new ChatMessage()
        );
    }
}
