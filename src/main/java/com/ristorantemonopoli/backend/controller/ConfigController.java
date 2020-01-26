package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.ConfigDTO;
import com.ristorantemonopoli.backend.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/config/descrizione", method = RequestMethod.POST)
    public void saveDescrizione(@RequestBody ConfigDTO request) {
        configService.inserisciDescrizione(request);
    }

    @RequestMapping(value = "/config/descrizione", method = RequestMethod.GET)
    public ConfigDTO getDescrizione() {
        return configService.retrieveDescrizione();
    }
}
