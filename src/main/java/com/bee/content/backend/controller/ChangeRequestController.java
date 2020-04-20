package com.bee.content.backend.controller;

import com.bee.content.backend.dto.ChangeRequestDTO;
import com.bee.content.backend.service.ChangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bee.content.backend.utils.MerchantUtils.MERCHANT_HEADER_KEY;
import static com.bee.content.backend.utils.MerchantUtils.validateMerchant;

@RestController
public class ChangeRequestController {

    @Autowired
    private ChangeRequestService service;

    @RequestMapping(value = "/request/template", method = RequestMethod.GET)
    public ChangeRequestDTO getTemplateChangeRequest(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return service.findTemplateChangeRequest(merchant);
    }

    @RequestMapping(value = "/request/plan", method = RequestMethod.GET)
    public ChangeRequestDTO getPlanChangeRequest(@RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        return service.findPlanChangeRequest(merchant);
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public void createNewRequest(@RequestBody ChangeRequestDTO requestDTO, @RequestHeader(MERCHANT_HEADER_KEY) String merchant) {
        validateMerchant(merchant);
        service.submitChangeRequest(requestDTO);
    }
}
