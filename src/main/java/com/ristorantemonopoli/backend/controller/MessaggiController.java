package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.MessaggioDTO;
import com.ristorantemonopoli.backend.service.MessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessaggiController {

    @Autowired
    private MessaggioService service;

    @RequestMapping(value = "/messaggi", method = RequestMethod.GET)
    private List<MessaggioDTO> retrieveMessaggi() {
        return service.retrieveMessaggi();
    }

    @RequestMapping(value = "/messaggi", method = RequestMethod.POST)
    private void rispondi(@RequestParam Long messaggioId, @RequestParam String risposta) {
        try {
            service.sendRisposta(messaggioId, risposta);
        } catch (Exception e) {
            // log response
        }
    }

}
