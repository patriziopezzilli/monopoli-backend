package com.ristorantemonopoli.backend.controller;

import com.ristorantemonopoli.backend.dto.RecensioneDTO;
import com.ristorantemonopoli.backend.service.TripAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripAdvisorController {

    @Autowired
    private TripAdvisorService tripAdvisorService;

    @RequestMapping(value = "/tripadavisor", method = RequestMethod.POST)
    public void saveRecensione(@RequestParam Long id, @RequestBody RecensioneDTO request) {
        tripAdvisorService.saveDescrizioneById(id, request);
    }

    @RequestMapping(value = "/tripadvisor", method = RequestMethod.GET)
    public RecensioneDTO getRecensioneById(@RequestParam Long id) {
        return tripAdvisorService.retrieveDescrizioneById(id);
    }
}
