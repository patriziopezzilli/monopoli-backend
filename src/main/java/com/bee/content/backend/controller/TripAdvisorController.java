package com.bee.content.backend.controller;

import com.bee.content.backend.dto.RecensioneDTO;
import com.bee.content.backend.service.TripAdvisorService;
import com.bee.content.backend.utils.ThreadState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class TripAdvisorController {

    @Autowired
    private TripAdvisorService tripAdvisorService;

    @RequestMapping(value = "/tripadvisor", method = RequestMethod.POST)
    public void saveRecensione(@RequestParam Long id, @RequestBody RecensioneDTO request, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        tripAdvisorService.saveDescrizioneById(id, request, ThreadState.INSTANCE.getMerchant());
    }

    @RequestMapping(value = "/tripadvisor", method = RequestMethod.GET)
    public RecensioneDTO getRecensioneById(@RequestParam Long id, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return tripAdvisorService.retrieveDescrizioneById(id, ThreadState.INSTANCE.getMerchant());
    }
}
