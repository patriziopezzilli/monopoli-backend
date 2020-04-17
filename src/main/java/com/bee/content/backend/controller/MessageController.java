package com.bee.content.backend.controller;

import com.bee.content.backend.dto.MessaggioDTO;
import com.bee.content.backend.service.MessageService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService service;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    private List<MessaggioDTO> retrieveMessaggi() {
        return service.retrieveMessaggi(ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    private void rispondi(@RequestParam Long messaggioId, @RequestParam String risposta) {
        try {
            service.sendRisposta(messaggioId, risposta, ThreadState.INSTANCE.getMerchant());
        } catch (Exception e) {
            // log response
        }
    }

}
