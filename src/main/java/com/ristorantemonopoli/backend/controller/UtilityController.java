package com.ristorantemonopoli.backend.controller;

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

    @RequestMapping(value = "/progress", method = RequestMethod.GET)
    public List<ProgressDTO> login() {
        List<ProgressDTO> progressDTOS = new ArrayList<>();

        ProgressDTO visitatori = new ProgressDTO();
        visitatori.setTitle("Visitatori del Sito");
        visitatori.setValue(service.countVisitors());
        visitatori.setActiveProgress(70);
        visitatori.setDescription("Visite effettuate su www.ristorantemonopoli.com");

        progressDTOS.add(visitatori);
        return progressDTOS;
    }
}
