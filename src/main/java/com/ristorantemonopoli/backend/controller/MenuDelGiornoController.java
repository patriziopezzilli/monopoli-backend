package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.MenuDelGiornoSaveRequest;
import com.ristorantemonopoli.backend.dto.PastoDTO;
import com.ristorantemonopoli.backend.dto.SubscriberDTO;
import com.ristorantemonopoli.backend.service.MenuDelGiornoService;
import com.ristorantemonopoli.backend.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuDelGiornoController {

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MenuDelGiornoService menuDelGiornoService;

    @RequestMapping(value = "/menudelgiorno/sottoscritti", method = RequestMethod.GET)
    public List<SubscriberDTO> subscriberList() {
        return subscriberService.menuSubscribers();
    }

    @RequestMapping(value = "/menudelgiorno/sottoscritti", method = RequestMethod.POST)
    public void subscriberList(@RequestParam String email) {
        subscriberService.saveNewSubscriber(email);
    }

    @RequestMapping(value = "/menudelgiorno", method = RequestMethod.GET)
    private List<PastoDTO> pastoDTOList(@RequestParam String categoria) {
        return menuDelGiornoService.retrievePasti(categoria);
    }

    @RequestMapping(value = "/menudelgiorno/stampa", method = RequestMethod.GET)
    private void stampa() {
        menuDelGiornoService.inviaInStampa();
    }

    @RequestMapping(value = "/menudelgiorno/mail", method = RequestMethod.GET)
    private void inviaViaMail() {
        menuDelGiornoService.notificaClienti();
    }

    @RequestMapping(value = "/menudelgiorno", method = RequestMethod.POST)
    private void saveMenuDelGiorno(@RequestBody MenuDelGiornoSaveRequest request) {
        menuDelGiornoService.saveMenuDelGiorno(request);
    }
}
