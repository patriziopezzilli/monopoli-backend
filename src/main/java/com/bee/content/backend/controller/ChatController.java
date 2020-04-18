package com.bee.content.backend.controller;

import com.bee.content.backend.dto.ChatMessageDTO;
import com.bee.content.backend.dto.ChatMessageMessageRequestDTO;
import com.bee.content.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/chat/messages", method = RequestMethod.GET)
    public List<ChatMessageDTO> getMessages(@RequestParam String email, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return chatService.retrieveChatMessage(email);
    }

    @RequestMapping(value = "/chat/messages", method = RequestMethod.POST)
    public void sendMessageToSupport(@RequestBody ChatMessageMessageRequestDTO request, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        chatService.sendMessageToSupport(request.getAuthor(), request.getMessage());
    }
}
