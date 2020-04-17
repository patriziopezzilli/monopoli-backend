package com.bee.content.backend.controller;

import com.bee.content.backend.dto.MessaggioDTO;
import com.bee.content.backend.service.MessageService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class MessageController {

    @Autowired
    private MessageService service;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    private List<MessaggioDTO> retrieveMessage(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return service.retrieveMessaggi(ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    private void response(@RequestParam Long messaggioId, @RequestParam String risposta, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        try {
            validateMerchant(merchant);
            service.sendRisposta(messaggioId, risposta, ThreadState.INSTANCE.getMerchant());
        } catch (Exception e) {
            // log response
        }
    }

}
