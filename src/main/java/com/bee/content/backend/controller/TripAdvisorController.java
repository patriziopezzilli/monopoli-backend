package com.bee.content.backend.controller;

import com.bee.content.backend.dto.RecensioneDTO;
import com.bee.content.backend.service.TripAdvisorService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripAdvisorController {

    @Autowired
    private TripAdvisorService tripAdvisorService;

    @RequestMapping(value = "/tripadvisor", method = RequestMethod.POST)
    public void saveRecensione(@RequestParam Long id, @RequestBody RecensioneDTO request) {
        tripAdvisorService.saveDescrizioneById(id, request, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/tripadvisor", method = RequestMethod.GET)
    public RecensioneDTO getRecensioneById(@RequestParam Long id) {
        return tripAdvisorService.retrieveDescrizioneById(id, ThreadState.INSTANCE.getMerchant());
    }
}
