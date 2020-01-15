package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.authentication.service.SubscriberService;
import com.ristorantemonopoli.backend.authentication.service.VisitorService;
import com.ristorantemonopoli.backend.dto.ProgressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UtilityController {

    @Autowired
    private VisitorService service;

    @Autowired
    private SubscriberService subscriberService;

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public List<ProgressDTO> login() {
        List<ProgressDTO> progressDTOS = new ArrayList<>();

        ProgressDTO visitatori = new ProgressDTO();
        visitatori.setTitle("Visitatori del Sito");
        visitatori.setValue(service.countVisitors());
        visitatori.setActiveProgress(70);
        visitatori.setDescription("Visite effettuate su www.ristorantemonopoli.com");

        ProgressDTO menuDelGiornoSubscriber = new ProgressDTO();
        menuDelGiornoSubscriber.setTitle("Registrati al Menù del Giorno");
        menuDelGiornoSubscriber.setValue(subscriberService.countMenuSubscriber());
        menuDelGiornoSubscriber.setActiveProgress(0);
        menuDelGiornoSubscriber.setDescription("Registrati alla newsletter del menù del giorno");

        ProgressDTO courtesySubscriber = new ProgressDTO();
        courtesySubscriber.setTitle("Registrati di Cortesia");
        courtesySubscriber.setValue(subscriberService.countCourtesySubscriber());
        courtesySubscriber.setActiveProgress(10);
        courtesySubscriber.setDescription("Registrati alla pagina di cortesia su www.ristorantemonopoli.com");

        progressDTOS.add(visitatori);
        progressDTOS.add(menuDelGiornoSubscriber);
        progressDTOS.add(courtesySubscriber);

        return progressDTOS;
    }
}
