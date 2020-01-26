package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.ProgressDTO;
import com.ristorantemonopoli.backend.service.SubscriberService;
import com.ristorantemonopoli.backend.service.VisitorService;
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

        Integer activeProgress = 0;
        if (visitatori.getValue() > 0 && visitatori.getValue() <= 100) {
            activeProgress = ((visitatori.getValue() * 100) / 100);
        } else if (visitatori.getValue() > 100 && visitatori.getValue() <= 1000) {
            activeProgress = ((visitatori.getValue() * 100) / 1000);
        } else if (visitatori.getValue() > 1000 && visitatori.getValue() <= 10000) {
            activeProgress = ((visitatori.getValue() * 100) / 10000);
        } else {
            activeProgress = 100;
        }
        visitatori.setActiveProgress(activeProgress);

        visitatori.setDescription("Visite effettuate su www.ristorantemonopoli.com");

        ProgressDTO menuDelGiornoSubscriber = new ProgressDTO();
        menuDelGiornoSubscriber.setTitle("Registrati al Menù del Giorno");
        menuDelGiornoSubscriber.setValue(subscriberService.countMenuSubscriber());

        Integer activeProgress2 = 0;
        if (menuDelGiornoSubscriber.getValue() > 0 && menuDelGiornoSubscriber.getValue() <= 100) {
            activeProgress2 = ((menuDelGiornoSubscriber.getValue() * 100) / 100);
        } else if (menuDelGiornoSubscriber.getValue() > 100 && menuDelGiornoSubscriber.getValue() <= 1000) {
            activeProgress2 = ((menuDelGiornoSubscriber.getValue() * 100) / 1000);
        } else if (menuDelGiornoSubscriber.getValue() > 1000 && menuDelGiornoSubscriber.getValue() <= 10000) {
            activeProgress2 = ((menuDelGiornoSubscriber.getValue() * 100) / 10000);
        } else {
            activeProgress2 = 100;
        }
        menuDelGiornoSubscriber.setActiveProgress(activeProgress2);

        menuDelGiornoSubscriber.setDescription("Registrati alla newsletter del menù del giorno");

        ProgressDTO courtesySubscriber = new ProgressDTO();
        courtesySubscriber.setTitle("Registrati di Cortesia");
        courtesySubscriber.setValue(subscriberService.countCourtesySubscriber());

        Integer activeProgress3 = 0;
        if (courtesySubscriber.getValue() > 0 && courtesySubscriber.getValue() <= 100) {
            activeProgress3 = ((courtesySubscriber.getValue() * 100) / 100);
        } else if (courtesySubscriber.getValue() > 100 && courtesySubscriber.getValue() <= 1000) {
            activeProgress3 = ((courtesySubscriber.getValue() * 100) / 1000);
        } else if (courtesySubscriber.getValue() > 1000 && courtesySubscriber.getValue() <= 10000) {
            activeProgress3 = ((courtesySubscriber.getValue() * 100) / 10000);
        } else {
            activeProgress3 = 100;
        }
        courtesySubscriber.setActiveProgress(activeProgress3);
        courtesySubscriber.setDescription("Registrati alla pagina di cortesia su www.ristorantemonopoli.com");
        progressDTOS.add(visitatori);
        progressDTOS.add(menuDelGiornoSubscriber);
        progressDTOS.add(courtesySubscriber);

        return progressDTOS;
    }
}
