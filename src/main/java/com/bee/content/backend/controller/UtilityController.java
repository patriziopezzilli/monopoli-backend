package com.bee.content.backend.controller;

import com.bee.content.backend.database.repository.MerchantRepository;
import com.bee.content.backend.dto.ProgressDTO;
import com.bee.content.backend.service.SubscriberService;
import com.bee.content.backend.service.VisitorService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class UtilityController {

    @Autowired
    private VisitorService service;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MerchantRepository merchantRepository;

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public List<ProgressDTO> systemOverview(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);

        List<ProgressDTO> progressDTOS = new ArrayList<>();

        ProgressDTO visitatori = new ProgressDTO();
        visitatori.setTitle("Visitatori del Sito");
        visitatori.setValue(service.countVisitors(ThreadState.INSTANCE.getMerchant()));

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

        visitatori.setDescription("");

        ProgressDTO menuDelGiornoSubscriber = new ProgressDTO();
        menuDelGiornoSubscriber.setTitle("Registrati alla newsletter");
        menuDelGiornoSubscriber.setValue(subscriberService.countMenuSubscriber(ThreadState.INSTANCE.getMerchant()));

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

        menuDelGiornoSubscriber.setDescription("");

        ProgressDTO booking = new ProgressDTO();
        booking.setTitle("Piano attuale");
        booking.setValue(0);
        booking.setActiveProgress(0);
        booking.setDescription("Bee Advanced");

        if(!merchantRepository.getByCode(merchant).getPlan().equalsIgnoreCase("MONOPOLI")) {
            progressDTOS.add(booking);
        }

        progressDTOS.add(visitatori);
        progressDTOS.add(menuDelGiornoSubscriber);
        return progressDTOS;
    }
}
